package br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes;

import org.springframework.stereotype.Component;

import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.investing.InvestingIndexPageWebCrawler;

@Component
public class IndexBrasil100MarketIndicatorWebCrawler extends InvestingIndexPageWebCrawler {

	public IndexBrasil100MarketIndicatorWebCrawler() {
		super("IBRX", "Índice Brasil 100 D1", "IBRX_D1", "https://br.investing.com/indices/brazil-index");
	}

}