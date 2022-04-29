package com.daniel.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("daniel").password("{noop}daniel").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//csrf evita subplantación de usuarios
		http.csrf().disable().authorizeRequests()
		.antMatchers("/api/v1/profesores/public").permitAll()
		.antMatchers("/api/v1/profesores/admin").hasRole("ADMIN")
		.antMatchers("/api/v1/profesores").hasRole("USER")
		.antMatchers("/*/escribirDB/**").hasRole("ADMIN")
		.and()
		.httpBasic();
		super.configure(http);
	}

}
