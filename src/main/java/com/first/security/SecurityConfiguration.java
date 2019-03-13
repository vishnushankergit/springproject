package com.first.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
			////.jdbcAuthentication() for 
			auth.inMemoryAuthentication()
			   .withUser("vishnu").password("vishnu").roles("ADMIN").and()
			   .withUser("neha").password("neha").roles("USER");
		}
	
		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception {
			httpSecurity.authorizeRequests()
						//.anyRequest()
			.antMatchers("*/topics/*").hasRole("USER")
						//.fullyAuthenticated()
						.and().httpBasic();		
			httpSecurity.csrf().disable();			
			
		}
}
