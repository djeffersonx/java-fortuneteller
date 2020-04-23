package br.com.fortuneteller.predictor.domain.service.webcrawlers.generics;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebCrawler {

	public static Document get(String url) throws IOException, InterruptedException {
		Thread.currentThread().sleep(500);
		return Jsoup.connect(url).get();
	}

}
