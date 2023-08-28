package com.masaischool.utils;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class Config {

	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {

		http.sessionManagement(se -> se.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).cors(cors -> {
			cors.configurationSource(new CorsConfigurationSource() {

				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

					CorsConfiguration cfg = new CorsConfiguration();
					cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
					cfg.setAllowedMethods(Collections.singletonList("*"));
					cfg.setAllowCredentials(true);
					cfg.setAllowedHeaders(Collections.singletonList("*"));
					cfg.setExposedHeaders(Arrays.asList("Authorization"));
					return cfg;
				}

			});
		})

				.authorizeHttpRequests(auth -> {

					auth.requestMatchers(HttpMethod.POST, "/users").permitAll()
						        .requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll() // this is for JWT on Swagger 
							.requestMatchers(HttpMethod.POST, "/users/admin","/vaccines/{memberId}","/vaccineinventories/{vaxCenterId}","/vaccinationCenters","/members/{userId}").hasRole("ADMIN")
							.requestMatchers(HttpMethod.POST, "/appointments/{memberId}/{vaxCenterId}","").hasRole("USER")
							.requestMatchers(HttpMethod.GET, "/getallmembers/{pageNumber}/{pageSize}","/getallusers/{pageNumber}/{pageSize}","/vaccinationCenters/{pageNumber}/{pageSize}","/vaccines/{pageNumber}/{pageSize}","/vaccineinventories/{pageNumber}/{pageSize}","/vaccineinventories/bycenter/{centerId}","/vaccineinventories/date/{date}","/vaccineinventories/id/{vaccineId}").hasRole("ADMIN")
							.requestMatchers(HttpMethod.GET, "/appointments/{bookingId}","/members/{memberId}","/members/aadhar/{aadharNo}","/members/pan/{panNo}","/users/{userId}","/users/aadhar/{AadharNo}","/users/pan/{panNo}","/vaccinationCenters/{centerId}").hasAnyRole("USER", "ADMIN")
							.requestMatchers(HttpMethod.PUT, "/appointments/{bookingId}","/users/{userId}").hasRole("USER")
							.requestMatchers(HttpMethod.PUT, "/members/{memberId}","/users/{userId}","/vaccinationCenters/{centerId}","/vaccines/{vaccineId}","/vaccineinventories/{vaccineInvenId}").hasRole("ADMIN")
							.requestMatchers(HttpMethod.DELETE,"/appointments/{bookingId}","/users/{userId}").hasRole("USER")
							.requestMatchers(HttpMethod.DELETE, "/members/{memberId}","/users/{userId}","/vaccinationCenters/{centerId}","/vaccines/{vaccineId}","/vaccineinventories/{vaccineInvenId}").hasRole("ADMIN")
							.anyRequest()
							.authenticated();

				})

				.csrf(csrf -> csrf.disable())
				.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
				.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
