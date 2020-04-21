package br.com.fortuneteller.predictor.domain.model;

import java.util.UUID;

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
@Table(name = "coreconomicindicsectorindex")
public class CorrelationEconomicIndicatorSectorIndex {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "ideconomicindicator", nullable = false, foreignKey = @ForeignKey(name = "fkcorecidcscidxideconidc"))
	private EconomicIndicator economicIndicator;

	@ManyToOne
	@JoinColumn(name = "idsectorindex", nullable = false, foreignKey = @ForeignKey(name = "fkcorecidcscidxidsecidex"))
	private SectorIndex sectorIndex;

}