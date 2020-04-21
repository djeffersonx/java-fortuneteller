package br.com.fortuneteller.predictor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FortunetellerPredictorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortunetellerPredictorApplication.class, args);
	}

}