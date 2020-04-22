package br.com.fortuneteller.predictor.domain.model;

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
@Table(name = "correlationmarketcontainer")
public class CorrelationMarketContainer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "idmarketcontainermain", foreignKey = @ForeignKey(name = "fkcorrmktctnridmktctnrmain"), nullable = true)
	private MarketContainer mainMarketContainer;

	@ManyToOne
	@JoinColumn(name = "idmarketcontainerrelated", foreignKey = @ForeignKey(name = "fkcorrmktctnridmktctnrrelated"), nullable = true)
	private MarketContainer relatedMarketContainer;

	@Column(name = "correlation", nullable = false)
	private Integer correlation = 0;
}