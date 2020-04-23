package br.com.fortuneteller.predictor.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fortuneteller.predictor.domain.model.MarketContainer;
import br.com.fortuneteller.predictor.domain.repository.MarketContainerRepository;

@Service
public class MarketContainerService {

	@Autowired
	private MarketContainerRepository repository;

	public MarketContainer findByKey(String key) {
		return repository.findByKey(key);
	}

	@Transactional
	public MarketContainer save(MarketContainer entity) {
		return repository.save(entity);
	}

}