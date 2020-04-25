package br.com.fortuneteller.predictor.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fortuneteller.predictor.domain.model.MarketContainerIndicator;
import br.com.fortuneteller.predictor.domain.repository.MarketContainerIndicatorRepository;

@Service
public class MarketContainerIndicatorService {

	@Autowired
	private MarketContainerIndicatorRepository repository;

	@Autowired
	private MarketContainerService marketContainerService;

	@Transactional
	public MarketContainerIndicator save(MarketContainerIndicator entity) {
		return repository.save(entity);
	}

	@Transactional
	public void createActual(MarketContainerIndicator entity) {
		markActualAsFalse().ifPresent(previous -> {
			entity.setPreviousValue(previous.getValue());
			entity.setRatioValue(entity.getValue().divide(entity.getPreviousValue()));
		});

		entity.setActual(true);
		entity.setMarketContainer(marketContainerService.findByKey(entity.getMarketContainer().getKey()));

		save(entity);
	}

	@Transactional
	public Optional<MarketContainerIndicator> markActualAsFalse() {
		Optional<MarketContainerIndicator> optActual = repository.findByActualIsTrue();
		if (optActual.isPresent()) {
			MarketContainerIndicator actual = optActual.get();
			actual.setActual(false);
			return Optional.of(save(actual));
		}
		return optActual;

	}

}