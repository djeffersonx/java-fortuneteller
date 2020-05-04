package br.com.fortuneteller.marketdata.domain.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoInsertMarketElementIndicator implements Serializable {

	private static final long serialVersionUID = -8712394904915903159L;

	private DtoMarketElement marketElement;
	private BigDecimal value;
	private LocalDateTime targetDate;

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DtoMarketElement implements Serializable {

		private static final long serialVersionUID = 2735131679129443927L;

		private String key;
	}

}