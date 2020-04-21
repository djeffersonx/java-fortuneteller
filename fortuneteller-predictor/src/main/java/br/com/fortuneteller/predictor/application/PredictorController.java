package br.com.fortuneteller.predictor.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;

@Log
@RestController
public class PredictorController {

	@GetMapping("/predictor/predict/{item}")
	public String predict(@PathVariable String item) {
		log.warning("teste");
		return item;
	}

}