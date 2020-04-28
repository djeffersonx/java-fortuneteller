package br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.stocks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import br.com.fortuneteller.predictor.domain.model.MarketContainer;
import br.com.fortuneteller.predictor.domain.model.MarketContainerIndicator;
import br.com.fortuneteller.predictor.domain.model.enums.EnumMarketContainerIndexType;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.AbstractMarketIndicatorWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.WebCrawler;

@Component
public class BrasilStocksMarketIndicatorWebCrawler extends AbstractMarketIndicatorWebCrawler {

	private static final String INVESTING_URL = "https://br.investing.com";

	public List<MarketContainerIndicator> getIndicators() throws Exception {

		List<MarketContainerIndicator> indicators = new ArrayList<MarketContainerIndicator>();

		Document baseStocksPage = WebCrawler.get(INVESTING_URL + "/equities/brazil");
		ArrayList<Element> tableRows = baseStocksPage.select(".marketInnerContent tr");

		for (Element element : tableRows) {

			Document stockPage = WebCrawler.get(INVESTING_URL + element.select("a").attr("href"));

			String stockKey = StringUtils.substringBetween(stockPage.select(".instrumentHead h1").text(), "(", ")");
			String valueString = stockPage.select("section .overViewBox.instrument .parentheses").text();
			if (stockKey != null) {
				MarketContainerIndicator indicator = new MarketContainerIndicator();
				indicator.setName(stockKey);
				indicator.setKey(stockKey);
				indicator.setStartValidity(new Date());
				indicator.setFinishValidity(new Date());
				indicator.setType(EnumMarketContainerIndexType.STOCK);
				indicator.setValue(new BigDecimal(valueString.replaceAll("\\%", "").replaceAll(",", ".")));
				indicator.setMarketContainer(new MarketContainer(stockKey));

				indicators.add(indicator);
			}
		}

		return indicators;
	}

}