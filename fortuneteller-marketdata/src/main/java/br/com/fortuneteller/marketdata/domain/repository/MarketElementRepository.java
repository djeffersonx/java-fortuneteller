package br.com.fortuneteller.marketdata.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fortuneteller.marketdata.domain.model.MarketElement;

public interface MarketElementRepository extends JpaRepository<MarketElement, UUID> {

	MarketElement findByKey(String key);

}
