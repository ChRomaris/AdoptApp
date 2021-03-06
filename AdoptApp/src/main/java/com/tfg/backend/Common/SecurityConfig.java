package com.tfg.backend.Common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtGenerator jwtGenerator;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().addFilter(new JwtFilter(authenticationManager(), jwtGenerator)).authorizeRequests()
				.antMatchers("/profile/register").permitAll()
				.antMatchers("/profile/login").permitAll()
				.antMatchers("/profile/update").permitAll()
				.antMatchers("/profile/setLocation").permitAll()
				.antMatchers("/profile/getInfo").permitAll()
				.antMatchers("/profile/enums").permitAll()
				.antMatchers("/shelter/animal/add").permitAll()
				.antMatchers("/shelter/animal/delete").permitAll()
				.antMatchers("/shelter/sheltersDistance").permitAll()
				.antMatchers("/shelter/animal/edit").permitAll()
				.antMatchers("/shelter/preferences").permitAll()
				.antMatchers("/animal/getAll").permitAll()
				.antMatchers("/animal/nearbyAdoptionAnimals").permitAll()
				.antMatchers("/shelter/findByUser").permitAll()
				.antMatchers("/user/update").permitAll()
				.antMatchers("/user/addLostAnimal").permitAll()
				.antMatchers("/user/preferences").permitAll()
				.antMatchers("/user/getAnimals").permitAll()
				.antMatchers("/user/deleteLost").permitAll()
				.antMatchers("/shelter/list").permitAll()
				.antMatchers("/shelter/animal/delete").permitAll()
				.antMatchers("/shelter/shelterList").permitAll()
				.antMatchers("/animal/edit").permitAll()
				.antMatchers("/animal/getInfo").permitAll()
				.antMatchers("/animal/getTypes").permitAll()
				.antMatchers("/animal/getLostAnimals").permitAll()
				.antMatchers("/animal/searchByDistance").permitAll()
				.antMatchers("/animal/filterAdoptAnimals").permitAll()
				.antMatchers("/animal/addLocation").permitAll()
				.antMatchers("/animal/locationsPage").permitAll()
				.antMatchers("/animal/locations").permitAll()
				.antMatchers("/animal/lostAnimalsInArea").permitAll()
				.antMatchers("/animal/lostAnimalInfo").permitAll()
				.antMatchers("/catalog/products/*").permitAll()
				.antMatchers("/catalog/products").permitAll()
				.antMatchers("/catalog/products").permitAll()
				.antMatchers("/chat/all").permitAll()
				.antMatchers("/chat/history").permitAll()
				.antMatchers("/chat/start").permitAll()
				.antMatchers("/chat/active").permitAll()
				.antMatchers("/handler/**").permitAll()
				.antMatchers("/**").hasRole("USER");

	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {

		CorsConfiguration config = new CorsConfiguration();
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");

		source.registerCorsConfiguration("/**", config);

		return source;

	}

}
