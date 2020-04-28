package br.com.fortuneteller.predictor.domain.model;

import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.fortuneteller.predictor.domain.model.enums.EnumMarketContainerType;
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

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private EnumMarketContainerType type;

	@ManyToOne
	@JoinColumn(name = "idparentcontainer", foreignKey = @ForeignKey(name = "fkmktctnridprtctnr"), nullable = true)
	private MarketContainer parentMarketContainer;

	@OneToMany(mappedBy = "marketContainer")
	private Set<MarketContainerIndicator> indicators;

	public MarketContainer(String key, String name, EnumMarketContainerType type) {
		this.name = name;
		this.key = key;
		this.type = type;
	}

	public MarketContainer(String name, String key, EnumMarketContainerType type,
			MarketContainer parentMarketContainer) {
		this(name, key, type);
		this.parentMarketContainer = parentMarketContainer;
	}

	public MarketContainer(String key) {
		this.key = key;
	}

	public static MarketContainer createCountry(String key, String name) {
		return new MarketContainer(key, name, EnumMarketContainerType.COUNTRY);
	}

	public static MarketContainer createStock(String key, String name) {
		return new MarketContainer(key, name, EnumMarketContainerType.STOCK);
	}

	public static MarketContainer createIndex(String key, String name) {
		return new MarketContainer(key, name, EnumMarketContainerType.INDEX);
	}

	public static MarketContainer createIndex(String key, String name, MarketContainer parent) {
		return new MarketContainer(key, name, EnumMarketContainerType.INDEX, parent);
	}

}