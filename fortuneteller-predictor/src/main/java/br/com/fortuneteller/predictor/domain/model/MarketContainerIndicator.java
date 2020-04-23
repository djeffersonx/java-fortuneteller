package br.com.fortuneteller.predictor.domain.model;

import java.math.BigDecimal;
import java.util.Date;
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

import br.com.fortuneteller.predictor.domain.model.enums.EnumDirectionPositiveSentimentMarketIndicator;
import br.com.fortuneteller.predictor.domain.model.enums.EnumMarketContainerIndexType;
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
@Table(name = "marketcontainerindex")
public class MarketContainerIndicator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "name", length = 255)
	private String name;

	@Column(name = "key", length = 255)
	private String key;

	@ManyToOne
	@JoinColumn(name = "idmarketcontainer", nullable = false, foreignKey = @ForeignKey(name = "fkmktctnridxidmktctnr"))
	private MarketContainer marketContainer;

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

	@Column(name = "datastartvalidity", nullable = false)
	private Date startValidity;

	@Column(name = "datafinshvalidity", nullable = false)
	private Date finishValidity;

	@Column(name = "estimateddelivery", nullable = false)
	private Date estimatedDeliveryDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "dirpositivesentiment", nullable = false)
	private EnumDirectionPositiveSentimentMarketIndicator directionPositiveSentiment = EnumDirectionPositiveSentimentMarketIndicator.POSITIVE;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private EnumMarketContainerIndexType type = EnumMarketContainerIndexType.MAIN;

}