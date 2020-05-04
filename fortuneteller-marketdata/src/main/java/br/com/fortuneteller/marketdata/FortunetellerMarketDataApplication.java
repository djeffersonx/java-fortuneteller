package br.com.fortuneteller.marketdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "br.com.fortuneteller.marketdata")
@EnableRetry
@EnableDiscoveryClient
@EnableScheduling
@EnableKafka
@EntityScan(basePackages = { "br.com.fortuneteller.marketdata.domain.model" })
@EnableJpaRepositories(basePackages = { "br.com.fortuneteller.marketdata.domain.repository" })
public class FortunetellerMarketDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortunetellerMarketDataApplication.class, args);
	}

}