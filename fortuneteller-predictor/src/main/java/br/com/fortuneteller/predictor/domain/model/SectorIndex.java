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
@Table(name = "sectorindex")
public class SectorIndex {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "name", length = 255)
	private String name;

	@ManyToOne
	@JoinColumn(name = "idparentsectorindex", nullable = true, foreignKey = @ForeignKey(name = "fksectorindexidparsecidx"))
	private SectorIndex parentSectorIndex;

	@ManyToOne
	@JoinColumn(name = "idcountry", nullable = false)
	private Country country;

}