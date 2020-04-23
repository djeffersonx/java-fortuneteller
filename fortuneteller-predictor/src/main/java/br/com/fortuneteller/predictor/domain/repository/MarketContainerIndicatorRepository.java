package br.com.fortuneteller.predictor.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fortuneteller.predictor.domain.model.MarketContainerIndicator;

public interface MarketContainerIndicatorRepository extends JpaRepository<MarketContainerIndicator, UUID> {

	Optional<MarketContainerIndicator> findByActualIsTrue();

}
