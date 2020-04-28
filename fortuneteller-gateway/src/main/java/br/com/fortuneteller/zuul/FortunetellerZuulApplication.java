package br.com.fortuneteller.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableZuulProxy
@EnableDiscoveryClient
@EnableOAuth2Sso
@SpringBootApplication
@EnableRetry
public class FortunetellerZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortunetellerZuulApplication.class, args);
	}

}