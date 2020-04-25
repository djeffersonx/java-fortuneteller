package br.com.fortuneteller.predictor.domain.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "marketcontainer")
public class MarketContainer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "name", length = 255)
	private String name;

	@Column(name = "key", length = 255)
	private String key;

	@ManyToOne
	@JoinColumn(name = "idparentcontainer", foreignKey = @ForeignKey(name = "fkmktctnridprtctnr"), nullable = true)
	private MarketContainer parentMarketContainer;

	@OneToMany(mappedBy = "marketContainer")
	private Set<MarketContainerIndicator> indicators;

	public MarketContainer(String name, String key) {
		this.name = name;
		this.key = key;
	}

	public MarketContainer(String name, String key, MarketContainer parentMarketContainer) {
		this(name, key);
		this.parentMarketContainer = parentMarketContainer;
	}

	public MarketContainer(String key) {
		this.key = key;
	}

}