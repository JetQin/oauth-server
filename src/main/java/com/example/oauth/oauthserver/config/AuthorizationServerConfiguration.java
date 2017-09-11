/** 
 * Project Name:oauth-server 
 * File Name:AuthorizationServerConfiguration.java 
 * Package Name:com.example.oauth.oauthserver
 * Date:Aug 31, 201710:14:10 AM 
 * Copyright (c) 2017, jetq All Rights Reserved. 
 * 
 */
package com.example.oauth.oauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import com.example.oauth.oauthserver.service.OauthUserDetailService;

/**
 * ClassName: AuthorizationServerConfiguration
 * 
 * @author jet
 * @version Configuration Framework 1.0
 * @since JDK 1.7
 */
@Configuration
@EnableOAuth2Sso
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Value("${resource.id:spring-boot-application}")
	private String resourceId;

	@Value("${access_token.validity_period:3600}")
	int accessTokenValiditySeconds = 3600;
	
	@Value("signing-key:oui214hmui23o4hm1pui3o2hp4m1o3h2m1o43")
	private String signinKey;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	OauthUserDetailService userDetailService;

//	@Autowired
//	private DataSource datasource;
//	
//	@Bean
//	public JwtAccessTokenConverter accessTokenConverter() {
//		final JwtAccessTokenConverter accessTokenConveter = new JwtAccessTokenConverter();
//		accessTokenConveter.setSigningKey(signinKey);
//		return accessTokenConveter;
//	}
//	
//	@Bean
//	public TokenStore tokenStore(){
//		return new JwtTokenStore(accessTokenConverter());
//	}
//	
//	@Bean
//	public TokenStore tokenStore(){
//		return new JdbcTokenStore(datasource);
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.oauth2.config.annotation.web.configuration.
	 * AuthorizationServerConfigurerAdapter#configure(org.springframework.
	 * security.oauth2.config.annotation.web.configurers.
	 * AuthorizationServerEndpointsConfigurer)
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer.authenticationManager(authenticationManager)
				 .userDetailsService(userDetailService);
	}
	
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		
//		security.tokenKeyAccess("permitAll()")
//				.checkTokenAccess("isAuthenticated()");
//	}
	/* (non-Javadoc)
	 * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.inMemory()
//				.withClient("normal-app")
//				.authorizedGrantTypes("authorization_code","implicit")
//				.authorities("ROLE_CLIENT")
//				.scopes("read","write")
//				.resourceIds(resourceId)
//				.accessTokenValiditySeconds(accessTokenValiditySeconds)
//			.and()
//				.withClient("trusted-app")
//				.authorizedGrantTypes("client_credentials","password")
//				.authorities("ROLE_TRUSTED_CLIENT")
//				.scopes("read","write")
//				.resourceIds(resourceId)
//				.accessTokenValiditySeconds(accessTokenValiditySeconds)
//				.secret("secret")
//			.and()
//			  .withClient("clientapp")
//	          .secret("123456")
//	          .authorizedGrantTypes("authorization_code", "refresh_token", "password")
//	          .scopes("read","write")
//	          .resourceIds(resourceId);
		clients.inMemory()
		.withClient("gigy").secret("secret")
		.accessTokenValiditySeconds(accessTokenValiditySeconds)
		.scopes("read", "write")
		.authorizedGrantTypes("password", "refresh_token")
		.resourceIds("resource");
	}
}
