package com.imlewis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*
@EnableJpaRepositories
@EnableRdsInstance(databaseName="***", dbInstanceIdentifier="***", username="***",password="***")
@EnableContextCredentials(accessKey="***", secretKey="***")
@EnableContextRegion(region="***")
*/
public class StarterApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StarterApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}
}
