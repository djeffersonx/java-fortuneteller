package br.com.fortuneteller.marketdata.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.fortuneteller.marketdata.domain.dtos.DtoInsertMarketElementIndicator;
import br.com.fortuneteller.marketdata.domain.service.MarketElementIndicatorService;

@Component
public class MarketElementIndicatorConsumer {

	@Autowired
	private MarketElementIndicatorService marketElementIndicatorService;

	@KafkaListener(topics = "${spring.kafka.topics.market-element-indicator}", groupId = "${spring.kafka.consumer.group-id}")
	public void receive(DtoInsertMarketElementIndicator insertMarketElementIndicator) {
		marketElementIndicatorService.createActual(insertMarketElementIndicator);
	}

}