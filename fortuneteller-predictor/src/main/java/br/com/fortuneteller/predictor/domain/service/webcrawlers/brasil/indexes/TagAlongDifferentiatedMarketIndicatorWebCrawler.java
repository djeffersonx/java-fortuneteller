package br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes;

import org.springframework.stereotype.Component;

import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.investing.InvestingIndexPageWebCrawler;

@Component
public class TagAlongDifferentiatedMarketIndicatorWebCrawler extends InvestingIndexPageWebCrawler {

	public TagAlongDifferentiatedMarketIndicatorWebCrawler() {
		super("ITAG", "Tag Along Diferenciado D1", "ITAG_D1", "https://br.investing.com/indices/tag-along-index");
	}

}