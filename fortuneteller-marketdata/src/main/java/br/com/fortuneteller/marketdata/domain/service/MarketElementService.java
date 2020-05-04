package br.com.fortuneteller.marketdata.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fortuneteller.marketdata.domain.model.MarketElement;
import br.com.fortuneteller.marketdata.domain.repository.MarketElementRepository;

@Service
public class MarketElementService {

	@Autowired
	private MarketElementRepository repository;

	public MarketElement findByKey(String key) {
		return repository.findByKey(key);
	}

	@Transactional
	public MarketElement save(MarketElement entity) {
		return repository.save(entity);
	}

}