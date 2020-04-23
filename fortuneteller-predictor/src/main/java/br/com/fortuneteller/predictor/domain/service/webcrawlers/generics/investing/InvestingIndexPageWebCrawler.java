package br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.investing;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import org.jsoup.nodes.Document;

import br.com.fortuneteller.predictor.domain.model.MarketContainer;
import br.com.fortuneteller.predictor.domain.model.MarketContainerIndicator;
import br.com.fortuneteller.predictor.domain.model.enums.EnumMarketContainerIndexType;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.AbstractMarketIndexWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.WebCrawler;

public abstract class InvestingIndexPageWebCrawler extends AbstractMarketIndexWebCrawler {

	private final String marketContainerKey;
	private final String name;
	private final String key;
	private final String url;

	public InvestingIndexPageWebCrawler(String marketContainerKey, String name, String key, String url) {
		this.marketContainerKey = marketContainerKey;
		this.name = name;
		this.key = key;
		this.url = url;
	}

	public String getMarketContainerKey() {
		return this.marketContainerKey;
	}

	public MarketContainerIndicator getIndicator() throws Exception {
		MarketContainerIndicator indicator = new MarketContainerIndicator();

		indicator.setName(name);
		indicator.setKey(key);

		indicator.setStartValidity(new Date());
		indicator.setFinishValidity(new Date());
		indicator.setType(EnumMarketContainerIndexType.MAIN);
		indicator.setValue(getValue());
		indicator.setMarketContainer(new MarketContainer());

		return indicator;
	}

	private BigDecimal getValue() throws IOException, InterruptedException {
		Document document = WebCrawler.get(url);
		String valueString = document.select("section .overViewBox.instrument .parentheses").text();
		return new BigDecimal(valueString.replaceAll("\\%", ""));
	}

}