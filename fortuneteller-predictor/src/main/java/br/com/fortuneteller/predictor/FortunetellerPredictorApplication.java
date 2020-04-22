package br.com.fortuneteller.predictor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@EntityScan(basePackages = "br.com.fortuneteller.predictor.domain.model")
public class FortunetellerPredictorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortunetellerPredictorApplication.class, args);
	}

}