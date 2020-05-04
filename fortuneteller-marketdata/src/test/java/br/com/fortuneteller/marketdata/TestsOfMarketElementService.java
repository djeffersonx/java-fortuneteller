package br.com.fortuneteller.marketdata;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.fortuneteller.marketdata.domain.model.MarketElement;
import br.com.fortuneteller.marketdata.domain.service.MarketElementService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@Transactional
class TestsOfMarketElementService {

	@Autowired
	private MarketElementService marketElementService;

	@Test
	@Order(1)
	@Rollback(false)
	void testCreateCountry() throws Exception {
		MarketElement country = marketElementService.save(MarketElement.createIndex("BR", "Brasil"));
		Assert.isTrue(country != null, "O objeto country/salvo deve ser diferente de null");
		Assert.isTrue(country.getId() != null, "O objeto country/salvo deve possuir um valor para id");

		country = marketElementService.findByKey("BR");

		Assert.isTrue(country != null, "O objeto country/find deve ser diferente de null");
		Assert.isTrue(country.getId() != null, "O objeto country/finddeve possuir um valor para id");

	}

//	@Test
//	@Order(2)
//	@Rollback(false)
//	void testCreateIndex() throws Exception {
//		MarketElement country = marketElementService.findByKey("BR");
//		Assert.isTrue(country != null, "O objeto country deve ser diferente de null");
//		MarketElement index = marketElementService
//				.save(MarketElement.createIndex("IBRX", "Índice Brasil 100", country));
//		Assert.isTrue(index != null, "O objeto index deve ser diferente de null");
//		Assert.isTrue(index.getId() != null, "O objeto index deve possuir um valor para id");
//	}
//
//	@Test
//	@Order(3)
//	@Rollback(false)
//	void testCreateStock() throws Exception {
//		MarketElement index = marketElementService.findByKey("IBRX");
//		Assert.isTrue(index != null, "O objeto index deve ser diferente de null");
//		MarketElement stock = marketElementService.save(MarketElement.createIndex("ABEV3", "Ambev SA", index));
//		Assert.isTrue(stock != null, "O objeto stock deve ser diferente de null");
//		Assert.isTrue(stock.getId() != null, "O objeto stock deve possuir um valor para id");
//
//	}

}