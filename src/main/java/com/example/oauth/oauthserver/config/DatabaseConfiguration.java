/** 
 * Project Name:oauth-server 
 * File Name:DatabaseConfiguration.java 
 * Package Name:com.example.oauth.oauthserver
 * Date:Aug 31, 201711:32:29 AM 
 * Copyright (c) 2017, jetq All Rights Reserved. 
 * 
 */
package com.example.oauth.oauthserver.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * ClassName: DatabaseConfiguration
 * 
 * @author jet
 * @version Configuration Framework 1.0
 * @since JDK 1.7
 */
@Configuration
public class DatabaseConfiguration {

	@Autowired
	Environment env;

	@Value("classpath:schema.sql")
	private Resource schemaScript;

	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}

	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(schemaScript);
		return populator;
	}

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		return dataSource;
	}
	

}
