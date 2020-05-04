package br.com.fortuneteller.marketdata.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import br.com.fortuneteller.marketdata.domain.model.enums.EnumDirectionPositiveSentimentMarketIndicator;
import br.com.fortuneteller.marketdata.domain.model.enums.EnumMarketElementIndexType;
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
@Table(name = "marketelementindex")
public class MarketElementIndicator implements Serializable {

	private static final long serialVersionUID = 6620413530409382003L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "name", length = 255)
	private String name;

	@Column(name = "key", length = 255)
	private String key;

	@ManyToOne
	@JoinColumn(name = "idmarketelement", nullable = false, foreignKey = @ForeignKey(name = "fkmktelmridxidmktctnr"))
	private MarketElement marketElement;

	@Column(name = "value", nullable = true)
	private BigDecimal value;

	@Column(name = "expectedvalue", nullable = true)
	private BigDecimal expectedValue;

	@Column(name = "previousvalue", nullable = true)
	private BigDecimal previousValue;

	@Column(name = "ratiovalue", nullable = true)
	private BigDecimal ratioValue;

	@Column(name = "actual", nullable = false)
	private Boolean actual = false;

	@CreatedDate
	@Column(name = "createddate", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "targetdate", nullable = false)
	private LocalDateTime targetDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "dirpositivesentiment", nullable = false)
	private EnumDirectionPositiveSentimentMarketIndicator directionPositiveSentiment = EnumDirectionPositiveSentimentMarketIndicator.POSITIVE;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private EnumMarketElementIndexType type = EnumMarketElementIndexType.MAIN;

}