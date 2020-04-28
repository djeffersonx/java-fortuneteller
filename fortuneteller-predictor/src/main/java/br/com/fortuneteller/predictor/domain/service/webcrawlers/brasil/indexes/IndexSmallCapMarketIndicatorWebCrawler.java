package br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes;

import org.springframework.stereotype.Component;

import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.investing.InvestingIndexPageWebCrawler;

@Component
public class IndexSmallCapMarketIndicatorWebCrawler extends InvestingIndexPageWebCrawler {

	public IndexSmallCapMarketIndicatorWebCrawler() {
		super("SMLL", "Índice Small Cap D1", "SMLL_D1", "https://br.investing.com/indices/small-cap-index");
	}

}