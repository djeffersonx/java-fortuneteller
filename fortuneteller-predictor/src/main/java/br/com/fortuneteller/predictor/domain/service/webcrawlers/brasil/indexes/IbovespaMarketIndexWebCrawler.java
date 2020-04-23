package br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes;

import org.springframework.stereotype.Component;

import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.investing.InvestingIndexPageWebCrawler;

@Component
public class IbovespaMarketIndexWebCrawler extends InvestingIndexPageWebCrawler {

	public IbovespaMarketIndexWebCrawler() {
		super("BVSP", "Ibovespa D1", "BVSP_D1", "https://br.investing.com/indices/bovespa");
	}

}