package com.example.oauth.oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.oauth.oauthserver.config.PersistenceConfiguration;


@SpringBootApplication
@Import(value={PersistenceConfiguration.class})
public class OauthServerApplication  {

	public static void main(String[] args) {
		SpringApplication.run(OauthServerApplication.class, args);
	}
}
