package br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes;

import org.springframework.stereotype.Component;

import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.investing.InvestingIndexPageWebCrawler;

@Component
public class IndexBrazilBroadMarketIndicatorWebCrawler extends InvestingIndexPageWebCrawler {

	public IndexBrazilBroadMarketIndicatorWebCrawler() {
		super("IBRA", "Índice Brasil Amplo D1", "IBRA_D1", "https://br.investing.com/indices/brazil-broad-based");
	}

}