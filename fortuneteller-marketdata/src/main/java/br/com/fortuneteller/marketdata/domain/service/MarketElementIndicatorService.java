package br.com.fortuneteller.marketdata.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fortuneteller.marketdata.domain.Orika;
import br.com.fortuneteller.marketdata.domain.dtos.DtoInsertMarketElementIndicator;
import br.com.fortuneteller.marketdata.domain.model.MarketElementIndicator;
import br.com.fortuneteller.marketdata.domain.repository.MarketElementIndicatorRepository;

@Service
public class MarketElementIndicatorService {

	@Autowired
	private MarketElementIndicatorRepository repository;

	@Autowired
	private MarketElementService marketBoxService;

	@Autowired
	private Orika orika;

	@Transactional
	public MarketElementIndicator save(MarketElementIndicator entity) {
		return repository.save(entity);
	}

	@Transactional
	public void createActual(DtoInsertMarketElementIndicator dto) {
		createActual(orika.map(dto, MarketElementIndicator.class));
	}

	@Transactional
	public void createActual(MarketElementIndicator entity) {
		markActualAsFalse().ifPresent(previous -> {
			entity.setPreviousValue(previous.getValue());
			entity.setRatioValue(entity.getValue().divide(entity.getPreviousValue()));
		});

		entity.setActual(true);
		entity.setMarketElement(marketBoxService.findByKey(entity.getMarketElement().getKey()));

		save(entity);
	}

	@Transactional
	public Optional<MarketElementIndicator> markActualAsFalse() {
		Optional<MarketElementIndicator> optActual = repository.findByActualIsTrue();
		if (optActual.isPresent()) {
			MarketElementIndicator actual = optActual.get();
			actual.setActual(false);
			return Optional.of(save(actual));
		}
		return optActual;

	}

}