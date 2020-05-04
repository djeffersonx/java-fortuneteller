package br.com.fortuneteller.marketdata.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fortuneteller.marketdata.domain.model.MarketElementIndicator;

public interface MarketElementIndicatorRepository extends JpaRepository<MarketElementIndicator, UUID> {

	Optional<MarketElementIndicator> findByActualIsTrue();

}
