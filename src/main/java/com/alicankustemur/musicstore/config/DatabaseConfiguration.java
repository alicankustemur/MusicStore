package com.alicankustemur.musicstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:/mysql.properties")
public class DatabaseConfiguration
{

	@Autowired
	public Environment environment;

	public DatabaseConfiguration()
	{

	}

	@Bean
	public DriverManagerDataSource createDriverManagerDataSourceBean()
	{
		DriverManagerDataSource driverManager = new DriverManagerDataSource();
		driverManager.setDriverClassName(environment.getProperty("driverClassName"));
		driverManager.setUrl(environment.getProperty("url"));
		driverManager.setUsername(environment.getProperty("username"));
		driverManager.setPassword(environment.getProperty("password"));
		return driverManager;
	}

}
