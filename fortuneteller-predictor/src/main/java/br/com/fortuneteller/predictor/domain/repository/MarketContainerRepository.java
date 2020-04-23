package br.com.fortuneteller.predictor.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fortuneteller.predictor.domain.model.MarketContainer;

public interface MarketContainerRepository extends JpaRepository<MarketContainer, UUID> {

	MarketContainer findByKey(String key);

}
