package br.com.fortuneteller.marketdata.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.fortuneteller.marketdata.domain.model.MarketElement;
import br.com.fortuneteller.marketdata.domain.service.MarketElementService;

@Component
public class DefaultDataInstaller {

	@Autowired
	private MarketElementService marketBoxService;

	@EventListener
	public void handleContextRefreshEvent(ContextRefreshedEvent context) {

//		MarketBox brasil = marketBoxService.save(MarketBox.createCountry("Brasil", "Brasil"));
//
//		marketBoxService.save(MarketBox.createIndex("IBRX", "Índice Brasil 100", brasil));
//		marketBoxService.save(MarketBox.createIndex("ITAG", "Tag Along Diferenciado", brasil));
//		marketBoxService.save(MarketBox.createIndex("SMLL", "Índice Small Cap", brasil));
//		marketBoxService.save(MarketBox.createIndex("MLCX", "Índice MidLarge Cap", brasil));
//		marketBoxService.save(MarketBox.createIndex("IBRA", "Índice Brasil Amplo", brasil));
//		marketBoxService.save(MarketBox.createIndex("IBX50", "Índice Brasil 50", brasil));
//		marketBoxService.save(MarketBox.createIndex("IBRX", "Índice Brasil 100", brasil));
//		marketBoxService.save(MarketBox.createIndex("BVSP", "Ibovespa", brasil));

	}

}