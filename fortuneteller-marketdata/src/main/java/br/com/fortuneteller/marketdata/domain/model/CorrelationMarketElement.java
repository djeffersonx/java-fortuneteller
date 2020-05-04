package br.com.fortuneteller.marketdata.domain.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "correlationmarketelement")
public class CorrelationMarketElement implements Serializable {

	private static final long serialVersionUID = 2219924156936306269L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "idmarketelementmain", foreignKey = @ForeignKey(name = "fkcorrmktelmridmktctnrmain"), nullable = true)
	private MarketElement mainMarketElement;

	@ManyToOne
	@JoinColumn(name = "idmarketelementrelated", foreignKey = @ForeignKey(name = "fkcorrmktelmridmktctnrrelated"), nullable = true)
	private MarketElement relatedMarketElement;

	@Column(name = "correlation", nullable = false)
	private Integer correlation = 0;
}