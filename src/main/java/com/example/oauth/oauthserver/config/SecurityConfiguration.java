/** 
 * Project Name:oauth-server 
 * File Name:SecurityConfiguration.java 
 * Package Name:com.example.oauth.oauthserver
 * Date:Aug 31, 201711:14:48 AM 
 * Copyright (c) 2017, jetq All Rights Reserved. 
 * 
 */
package com.example.oauth.oauthserver.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;


/** 
 * ClassName: SecurityConfiguration  
 * 
 * @author jet 
 * @version Configuration Framework 1.0
 * @since JDK 1.7 
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN","USER")
//					.and().withUser("user").password("user").roles("USER");
//	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN","USER")
		.and().withUser("user").password("user").roles("CLIENT","TRUSTED_CLIENT");
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/","/home").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login2").permitAll()
			.and()
			.logout().permitAll()
//			.and()
//			.addFilterAfter(new CSRFAttributeFilter(), CsrfFilter.class)
//			.csrf().csrfTokenRepository(csrfTokenRepository());
			;
		
	}

//	private CsrfTokenRepository csrfTokenRepository(){
//		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//		repository.setHeaderName("X-XSRF-TOKEN");
//		return repository;
//	}
}
