package br.com.fortuneteller.predictor.domain.model;

import java.math.BigDecimal;
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
@Table(name = "economicindicatorvalue")
public class EconomicIndicatorValue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "ideconomicindicator", nullable = false, foreignKey = @ForeignKey(name = "fkecoindicvalidecoindic"))
	private EconomicIndicator economicIndicator;

	@ManyToOne
	@JoinColumn(name = "idcountry", nullable = false, foreignKey = @ForeignKey(name = "fkecoindicvalidcountry"))
	private Country country;

	@Column(name = "actual")
	private BigDecimal actual;

	@Column(name = "forecast")
	private BigDecimal forecast;

	@Column(name = "previous")
	private BigDecimal previous;

}