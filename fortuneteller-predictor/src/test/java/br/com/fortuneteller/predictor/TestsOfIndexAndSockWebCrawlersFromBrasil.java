package br.com.fortuneteller.predictor;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import br.com.fortuneteller.predictor.domain.model.MarketContainerIndicator;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IbovespaMarketIndexWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IndexBrasil100MarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IndexBrasil50MarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IndexBrasilBroadMarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IndexMidLargeCapMarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IndexSmallCapMarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.TagAlongDifferentiatedMarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.stocks.BrasilStocksMarketIndicatorWebCrawler;

//@SpringBootTest
class TestsOfIndexAndSockWebCrawlersFromBrasil {

//	@Autowired
//	private IbovespaMarketIndexWebCrawler ibovespaMarketIndexWebCrawler;
//
//	@Autowired
//	private IndexBrasil100MarketIndicatorWebCrawler indexBrasil100MarketIndicatorWebCrawler;
//
//	@Autowired
//	private IndexBrasil50MarketIndicatorWebCrawler indexBrasil50MarketIndicatorWebCrawler;
//
//	@Autowired
//	private IndexBrasilBroadMarketIndicatorWebCrawler indexBrasilBroadMarketIndicatorWebCrawler;
//
//	@Autowired
//	private IndexMidLargeCapMarketIndicatorWebCrawler indiceMidLargeCapMarketIndicatorWebCrawler;
//
//	@Autowired
//	private IndexSmallCapMarketIndicatorWebCrawler indiceSmallCapMarketIndicatorWebCrawler;
//
//	@Autowired
//	private TagAlongDifferentiatedMarketIndicatorWebCrawler tagAlongDifferentiatedMarketIndicatorWebCrawler;
//
//	@Autowired
//	private BrasilStocksMarketIndicatorWebCrawler brasilStocksMarketIndicatorWebCrawler;
//
//	@Test
//	void testIbovespaMarketIndexWebCrawler() throws Exception {
//		List<MarketContainerIndicator> indicators = ibovespaMarketIndexWebCrawler.getIndicators();
//		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
//		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
//	}
//
//	@Test
//	void testIndexBrasil100MarketIndicatorWebCrawler() throws Exception {
//		List<MarketContainerIndicator> indicators = indexBrasil100MarketIndicatorWebCrawler.getIndicators();
//		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
//		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
//	}
//
//	@Test
//	void testIndexIndexBrasil50MarketIndicatorWebCrawler() throws Exception {
//		List<MarketContainerIndicator> indicators = indexBrasil50MarketIndicatorWebCrawler.getIndicators();
//		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
//		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
//	}
//
//	@Test
//	void testIndexBrasilBroadMarketIndicatorWebCrawler() throws Exception {
//		List<MarketContainerIndicator> indicators = indexBrasilBroadMarketIndicatorWebCrawler.getIndicators();
//		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
//		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
//	}
//
//	@Test
//	void testIndiceMidLargeCapMarketIndicatorWebCrawler() throws Exception {
//		List<MarketContainerIndicator> indicators = indiceMidLargeCapMarketIndicatorWebCrawler.getIndicators();
//		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
//		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
//	}
//
//	@Test
//	void testIndiceSmallCapMarketIndicatorWebCrawler() throws Exception {
//		List<MarketContainerIndicator> indicators = indiceSmallCapMarketIndicatorWebCrawler.getIndicators();
//		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
//		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
//	}
//
//	@Test
//	void testTagAlongDifferentiatedMarketIndicatorWebCrawler() throws Exception {
//		List<MarketContainerIndicator> indicators = tagAlongDifferentiatedMarketIndicatorWebCrawler.getIndicators();
//		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
//		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
//	}
//
//	@Test
//	void testBrasilStocksMarketIndicatorWebCrawler() throws Exception {
//		List<MarketContainerIndicator> indicators = brasilStocksMarketIndicatorWebCrawler.getIndicators();
//		Assert.isTrue(indicators.size() > 15, "O total de ações deve ser maior que 10");
//
//		Assert.isTrue(indicators.stream().filter(e -> e.getValue() == null).collect(Collectors.toList())
//				.size() == indicators.size(), "Todas as ações devem ter um valor definido");
//	}

}
