package com.randcodez.rest.basic.auth;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Randjith
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfigurationBasicAuth {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll());

		http.csrf(csrf -> csrf.disable());

		http.httpBasic(withDefaults());

		return http.build();
	}

}
