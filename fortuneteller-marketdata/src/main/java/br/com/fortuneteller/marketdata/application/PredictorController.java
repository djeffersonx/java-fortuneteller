package br.com.fortuneteller.marketdata.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PredictorController {

	@GetMapping("/predictor/predict/{item}")
	public String predict(@PathVariable String item) {
		return item;
	}

}