package br.com.fortuneteller.predictor.domain.service.webcrawlers.generics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fortuneteller.predictor.domain.model.MarketContainerIndicator;
import br.com.fortuneteller.predictor.domain.service.MarketContainerIndicatorService;
import lombok.extern.java.Log;

@Log
public abstract class AbstractMarketIndicatorWebCrawler {

	@Autowired
	private MarketContainerIndicatorService marketContainerIndicatorService;

	public abstract List<MarketContainerIndicator> getIndicators() throws Exception;

	public void run() {
		try {
			getIndicators().forEach(e -> {
				marketContainerIndicatorService.createActual(e);
			});
		} catch (Exception e) {
			log.throwing(AbstractMarketIndicatorWebCrawler.class.getName(), "run", e);
		}
	}

}