package br.com.fortuneteller.marketdata.domain.model;

import java.io.Serializable;
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

import br.com.fortuneteller.marketdata.domain.model.enums.EnumMarketElementType;
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
@Table(name = "marketelement")
public class MarketElement implements Serializable {

	private static final long serialVersionUID = 2425519644139568570L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "name", length = 255)
	private String name;

	@Column(name = "key", length = 255)
	private String key;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private EnumMarketElementType type;

	@ManyToOne
	@JoinColumn(name = "idparentelement", foreignKey = @ForeignKey(name = "fkmktelmridprtctnr"), nullable = true)
	private MarketElement parentMarketElement;

	@OneToMany(mappedBy = "marketElement")
	private Set<MarketElementIndicator> indicators;

	public MarketElement(String key, String name, EnumMarketElementType type) {
		this.name = name;
		this.key = key;
		this.type = type;
	}

	public MarketElement(String name, String key, EnumMarketElementType type,
			MarketElement parentMarketElement) {
		this(name, key, type);
		this.parentMarketElement = parentMarketElement;
	}

	public MarketElement(String key) {
		this.key = key;
	}

	public static MarketElement createCountry(String key, String name) {
		return new MarketElement(key, name, EnumMarketElementType.COUNTRY);
	}

	public static MarketElement createStock(String key, String name) {
		return new MarketElement(key, name, EnumMarketElementType.STOCK);
	}

	public static MarketElement createIndex(String key, String name) {
		return new MarketElement(key, name, EnumMarketElementType.INDEX);
	}

	public static MarketElement createIndex(String key, String name, MarketElement parent) {
		return new MarketElement(key, name, EnumMarketElementType.INDEX, parent);
	}

}