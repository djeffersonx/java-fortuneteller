package br.com.fortuneteller.predictor.domain.service.webcrawlers.generics;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fortuneteller.predictor.domain.model.MarketContainerIndicator;
import br.com.fortuneteller.predictor.domain.service.MarketContainerIndicatorService;
import lombok.extern.java.Log;

@Log
public abstract class AbstractMarketIndexWebCrawler {

	@Autowired
	private MarketContainerIndicatorService marketContainerIndicatorService;

	public abstract String getMarketContainerKey();

	public abstract MarketContainerIndicator getIndicator() throws Exception;

	public void run() {
		try {
			marketContainerIndicatorService.createActual(getIndicator(), getMarketContainerKey());
		} catch (Exception e) {
			log.throwing(AbstractMarketIndexWebCrawler.class.getName(), "run", e);
		}
	}

}