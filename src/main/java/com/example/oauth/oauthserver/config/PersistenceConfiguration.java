/** 
 * Project Name:oauth-server 
 * File Name:DatabaseConfiguration.java 
 * Package Name:com.example.oauth.oauthserver
 * Date:Aug 31, 201711:32:29 AM 
 * Copyright (c) 2017, jetq All Rights Reserved. 
 * 
 */
package com.example.oauth.oauthserver.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName: DatabaseConfiguration
 * 
 * @author jet
 * @version Configuration Framework 1.0
 * @since JDK 1.7
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = "com.example.oauth.oauthserver.repository")
public class PersistenceConfiguration {

	private static final String DOMAIN_PACKAGE = "com.example.oauth.oauthserver.domain";

	@Autowired
	Environment env;

	// @Value("classpath:schema.sql")
	// private Resource schemaScript;
	//
	// @Bean
	// public DataSourceInitializer dataSourceInitializer(DataSource dataSource)
	// {
	// DataSourceInitializer initializer = new DataSourceInitializer();
	// initializer.setDataSource(dataSource);
	// initializer.setDatabasePopulator(databasePopulator());
	// return initializer;
	// }
	//
	// private DatabasePopulator databasePopulator() {
	// ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	// populator.addScript(schemaScript);
	// return populator;
	// }

	@Bean
	public DataSource dataSource() {

		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		// dataSource.setUrl(env.getProperty("jdbc.url"));
		// dataSource.setUsername(env.getProperty("jdbc.user"));
		// dataSource.setPassword(env.getProperty("jdbc.pass"));
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setGenerateDdl(true);
		return jpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
		lemfb.setDataSource(dataSource());
		lemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lemfb.setPackagesToScan(DOMAIN_PACKAGE);
		lemfb.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		lemfb.setJpaProperties(hibernateProperties());
		return lemfb;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
//		properties.put("hibernate.enable_lazy_load_no_trans", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		return properties;
	}

}
