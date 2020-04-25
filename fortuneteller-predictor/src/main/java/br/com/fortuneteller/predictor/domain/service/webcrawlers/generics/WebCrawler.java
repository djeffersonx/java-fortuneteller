package br.com.fortuneteller.predictor.domain.service.webcrawlers.generics;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebCrawler {

	private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.113 Safari/537.36";

	public static Document get(String url) throws IOException, InterruptedException {
		Thread.currentThread().sleep(500);
		return Jsoup.connect(url).userAgent(USER_AGENT).get();
	}

}