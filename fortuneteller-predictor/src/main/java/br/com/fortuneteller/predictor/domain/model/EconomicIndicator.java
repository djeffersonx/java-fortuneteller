package br.com.fortuneteller.predictor.domain.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.fortuneteller.predictor.domain.model.enums.EnumEconomicIndicators;
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
@Table(name = "economicindicator")
public class EconomicIndicator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(name = "name", length = 255, nullable = false)
	private EnumEconomicIndicators indicator;

	@OneToMany(mappedBy = "economicIndicator")
	private Set<CorrelationEconomicIndicatorSectorIndex> correlationSectorIndex;

}