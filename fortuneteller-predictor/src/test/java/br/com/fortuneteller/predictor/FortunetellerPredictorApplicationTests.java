package br.com.fortuneteller.predictor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import br.com.fortuneteller.predictor.domain.model.MarketContainerIndicator;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IbovespaMarketIndexWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IndexBrazil100MarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IndexBrazil50MarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IndexBrazilBroadMarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IndiceMidLargeCapMarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.IndiceSmallCapMarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.indexes.TagAlongDifferentiatedMarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.stocks.BrazilStocksMarketIndicatorWebCrawler;

@SpringBootTest
class FortunetellerPredictorApplicationTests {

	@Autowired
	private IbovespaMarketIndexWebCrawler ibovespaMarketIndexWebCrawler;

	@Autowired
	private IndexBrazil100MarketIndicatorWebCrawler indexBrazil100MarketIndicatorWebCrawler;

	@Autowired
	private IndexBrazil50MarketIndicatorWebCrawler indexBrazil50MarketIndicatorWebCrawler;

	@Autowired
	private IndexBrazilBroadMarketIndicatorWebCrawler indexBrazilBroadMarketIndicatorWebCrawler;

	@Autowired
	private IndiceMidLargeCapMarketIndicatorWebCrawler indiceMidLargeCapMarketIndicatorWebCrawler;

	@Autowired
	private IndiceSmallCapMarketIndicatorWebCrawler indiceSmallCapMarketIndicatorWebCrawler;

	@Autowired
	private TagAlongDifferentiatedMarketIndicatorWebCrawler tagAlongDifferentiatedMarketIndicatorWebCrawler;

	@Autowired
	private BrazilStocksMarketIndicatorWebCrawler brazilStocksMarketIndicatorWebCrawler;

	@Test
	void testIbovespaMarketIndexWebCrawler() throws Exception {
		List<MarketContainerIndicator> indicators = ibovespaMarketIndexWebCrawler.getIndicators();
		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
	}

	@Test
	void testIndexBrazil100MarketIndicatorWebCrawler() throws Exception {
		List<MarketContainerIndicator> indicators = indexBrazil100MarketIndicatorWebCrawler.getIndicators();
		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
	}

	@Test
	void testIndexIndexBrazil50MarketIndicatorWebCrawler() throws Exception {
		List<MarketContainerIndicator> indicators = indexBrazil50MarketIndicatorWebCrawler.getIndicators();
		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
	}

	@Test
	void testIndexBrazilBroadMarketIndicatorWebCrawler() throws Exception {
		List<MarketContainerIndicator> indicators = indexBrazilBroadMarketIndicatorWebCrawler.getIndicators();
		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
	}

	@Test
	void testIndiceMidLargeCapMarketIndicatorWebCrawler() throws Exception {
		List<MarketContainerIndicator> indicators = indiceMidLargeCapMarketIndicatorWebCrawler.getIndicators();
		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
	}

	@Test
	void testIndiceSmallCapMarketIndicatorWebCrawler() throws Exception {
		List<MarketContainerIndicator> indicators = indiceSmallCapMarketIndicatorWebCrawler.getIndicators();
		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
	}

	@Test
	void testTagAlongDifferentiatedMarketIndicatorWebCrawler() throws Exception {
		List<MarketContainerIndicator> indicators = tagAlongDifferentiatedMarketIndicatorWebCrawler.getIndicators();
		Assert.isTrue(indicators.size() == 1, "O total de indicadores deve ser igual a 1");
		Assert.isTrue(indicators.get(0).getValue() != null, "O indicador deve possuir um valor");
	}

	@Test
	void testBrazilStocksMarketIndicatorWebCrawler() throws Exception {
		List<MarketContainerIndicator> indicators = brazilStocksMarketIndicatorWebCrawler.getIndicators();
		Assert.isTrue(indicators.size() > 15, "O total de ações deve ser maior que 10");

		Assert.isTrue(indicators.stream().filter(e -> e.getValue() == null).collect(Collectors.toList())
				.size() == indicators.size(), "Todas as ações devem ter um valor definido");
	}

}
