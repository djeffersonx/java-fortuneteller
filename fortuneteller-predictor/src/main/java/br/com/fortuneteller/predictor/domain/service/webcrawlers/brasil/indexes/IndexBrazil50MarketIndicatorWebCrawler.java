package br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes;

import org.springframework.stereotype.Component;

import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.investing.InvestingIndexPageWebCrawler;

@Component
public class IndexBrazil50MarketIndicatorWebCrawler extends InvestingIndexPageWebCrawler {

	public IndexBrazil50MarketIndicatorWebCrawler() {
		super("IBX50", "Índice Brasil 50 D1", "IBRX50_D1", "https://br.investing.com/indices/brazil-index-50");
	}

}