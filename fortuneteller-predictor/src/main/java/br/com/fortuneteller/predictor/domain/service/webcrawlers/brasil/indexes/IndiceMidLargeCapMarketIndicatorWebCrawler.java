package br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes;

import org.springframework.stereotype.Component;

import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.investing.InvestingIndexPageWebCrawler;

@Component
public class IndiceMidLargeCapMarketIndicatorWebCrawler extends InvestingIndexPageWebCrawler {

	public IndiceMidLargeCapMarketIndicatorWebCrawler() {
		super("MLCX", "Índice MidLarge Cap D1", "MLCX_D1", "https://br.investing.com/indices/mid-large-cap-index");
	}

}