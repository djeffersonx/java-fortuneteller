package br.com.fortuneteller.predictor.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.fortuneteller.predictor.domain.model.MarketContainer;
import br.com.fortuneteller.predictor.domain.service.MarketContainerService;

@Component
public class DefaultDataInstaller {

	@Autowired
	private MarketContainerService marketContainerService;

	@EventListener
	public void handleContextRefreshEvent(ContextRefreshedEvent context) {

//		MarketContainer brasil = marketContainerService.save(MarketContainer.createCountry("Brasil", "Brasil"));
//
//		marketContainerService.save(MarketContainer.createIndex("IBRX", "Índice Brasil 100", brasil));
//		marketContainerService.save(MarketContainer.createIndex("ITAG", "Tag Along Diferenciado", brasil));
//		marketContainerService.save(MarketContainer.createIndex("SMLL", "Índice Small Cap", brasil));
//		marketContainerService.save(MarketContainer.createIndex("MLCX", "Índice MidLarge Cap", brasil));
//		marketContainerService.save(MarketContainer.createIndex("IBRA", "Índice Brasil Amplo", brasil));
//		marketContainerService.save(MarketContainer.createIndex("IBX50", "Índice Brasil 50", brasil));
//		marketContainerService.save(MarketContainer.createIndex("IBRX", "Índice Brasil 100", brasil));
//		marketContainerService.save(MarketContainer.createIndex("BVSP", "Ibovespa", brasil));

	}

}