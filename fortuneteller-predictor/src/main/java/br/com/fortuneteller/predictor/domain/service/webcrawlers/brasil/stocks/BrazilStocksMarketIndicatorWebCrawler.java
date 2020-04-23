package br.com.fortuneteller.predictor.domain.service.webcrawlers.brasil.stocks;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import br.com.fortuneteller.predictor.domain.model.MarketContainer;
import br.com.fortuneteller.predictor.domain.model.MarketContainerIndicator;
import br.com.fortuneteller.predictor.domain.model.enums.EnumMarketContainerIndexType;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.AbstractMarketIndexWebCrawler;
import br.com.fortuneteller.predictor.domain.service.webcrawlers.generics.WebCrawler;

@Component
public class BrazilStocksMarketIndicatorWebCrawler extends AbstractMarketIndexWebCrawler {

	public MarketContainerIndicator getIndicator() throws Exception {
		MarketContainerIndicator indicator = new MarketContainerIndicator();

//		indicator.setName(name);
//		indicator.setKey(key);

		indicator.setStartValidity(new Date());
		indicator.setFinishValidity(new Date());
		indicator.setType(EnumMarketContainerIndexType.MAIN);
		indicator.setValue(getValue());
		indicator.setMarketContainer(new MarketContainer());

		return indicator;
	}

	private BigDecimal getValue() throws IOException {
		return null;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		String investingBaseUrl = "https://br.investing.com";
		Document baseStocksPage = WebCrawler.get(investingBaseUrl + "/equities/brazil");
		ArrayList<Element> tableRows = baseStocksPage.select(".marketInnerContent tr");

		for (Element element : tableRows) {

			Document stockPage = WebCrawler.get(investingBaseUrl + element.select("a").attr("href"));

			String stockKey = StringUtils.substringBetween(stockPage.select(".instrumentHead h1").text(), "(", ")");
			String valueString = stockPage.select("section .overViewBox.instrument .parentheses").text();

			System.out.println(stockKey + ": " + valueString);
		}

	}

	@Override
	public String getMarketContainerKey() {
		return "BVSP";
	}

}