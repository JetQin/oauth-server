/** 
 * Project Name:oauth-server 
 * File Name:OauthWebConfiguration.java 
 * Package Name:com.example.oauth.oauthserver.config
 * Date:Aug 31, 20174:29:36 PM 
 * Copyright (c) 2017, jetq All Rights Reserved. 
 * 
 */
package com.example.oauth.oauthserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/** 
 * ClassName: OauthWebConfiguration  
 * 
 * @author jet 
 * @version Configuration Framework 1.0
 * @since JDK 1.7 
 */
@Configuration
public class OauthWebConfiguration extends WebMvcConfigurerAdapter{

		/* (non-Javadoc)
		 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
		 */
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			
			registry.addViewController("/login").setViewName("login");
			registry.addViewController("/greeting").setViewName("greeting");
		}
}
