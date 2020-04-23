package br.com.fortuneteller.predictor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EntityScan(basePackages = { "br.com.fortuneteller.predictor.domain.model" })
@EnableJpaRepositories(basePackages = { "br.com.fortuneteller.predictor.domain.repository" })
@SpringBootApplication
@EnableDiscoveryClient
public class FortunetellerPredictorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortunetellerPredictorApplication.class, args);
	}

}