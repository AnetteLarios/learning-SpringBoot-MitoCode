package com.testweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.testweb.services.UserService;

 
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
	
	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder Bcrypt;
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		
		BCryptPasswordEncoder cryptPassword = new BCryptPasswordEncoder();
		return cryptPassword;
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(Bcrypt);
	}
	
	@SuppressWarnings({ "deprecation", "removal" })
	protected void configure(HttpSecurity http)throws  Exception{
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();	
}
}
 