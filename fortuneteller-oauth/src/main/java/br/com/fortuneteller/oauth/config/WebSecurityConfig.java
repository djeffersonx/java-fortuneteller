package br.com.fortuneteller.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //
				.antMatchers("/oauth/**").permitAll() //
				.anyRequest().authenticated() //
				.and() //
				.csrf().disable();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager( //
				User.builder() //
						.username("user") //
						.password("$2a$10$cEzD3rF2Eq.H/kW99xR7yOQSz1rkkSC/SaWPmwC054zKTO79kFiHi") // user
						.roles("USER") //
						.build() //
		);
	}
}