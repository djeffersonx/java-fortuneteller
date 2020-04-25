package br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.investing;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Document;

import br.com.fortuneteller.predictor.domain.model.MarketContainer;
import br.com.fortuneteller.predictor.domain.model.MarketContainerIndicator;
import br.com.fortuneteller.predictor.domain.model.enums.EnumMarketContainerIndexType;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.AbstractMarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.WebCrawler;
import lombok.extern.java.Log;

@Log
public abstract class InvestingIndexPageWebCrawler extends AbstractMarketIndicatorWebCrawler {

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

	public List<MarketContainerIndicator> getIndicators() throws Exception {
		MarketContainerIndicator indicator = new MarketContainerIndicator();

		indicator.setName(name);
		indicator.setKey(key);
		indicator.setStartValidity(new Date());
		indicator.setFinishValidity(new Date());
		indicator.setType(EnumMarketContainerIndexType.MAIN);
		indicator.setValue(getValue());
		indicator.setMarketContainer(new MarketContainer(marketContainerKey));

		log.info("Get data from url: " + url + ", data: " + indicator);

		return Collections.singletonList(indicator);
	}

	private BigDecimal getValue() throws IOException, InterruptedException {
		Document document = WebCrawler.get(url);
		String valueString = document.select("section .overViewBox.instrument .parentheses").text();
		return new BigDecimal(valueString.replaceAll("\\%", "").replaceAll(",", "."));
	}

}