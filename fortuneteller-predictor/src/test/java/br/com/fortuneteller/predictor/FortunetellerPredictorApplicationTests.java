package br.com.fortuneteller.predictor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import br.com.fortuneteller.predictor.domain.model.MarketContainer;
import br.com.fortuneteller.predictor.domain.service.MarketContainerService;

@SpringBootTest
class FortunetellerPredictorApplicationTests {

	@Autowired
	private MarketContainerService containerService;

	@Test
	void contextLoads() {
		MarketContainer ibovespa = containerService.save(new MarketContainer("Ibovespa", "BVSP"));
		MarketContainer iba = containerService.save(new MarketContainer("Índice Brasil Amplo ", "IBRA", ibovespa));

		Assert.isTrue(ibovespa.getId() != null, "ID Ibovespa não encontrada");
		Assert.isTrue(iba.getId() != null, "ID do Índice Brasil Amplo não encontrada");

	}

}
