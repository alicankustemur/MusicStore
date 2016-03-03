package com.alicankustemur.musicstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@Configuration
@PropertySource("classpath:/mysql.properties")
@ComponentScan(basePackages = "com.alicankustemur.musicstore")
public class BeanConfiguration
{

	@Autowired
	public Environment		environment;

	@Autowired(required = false)
	private Configuration	databaseConfiguration;

	@Bean
	public SingleConnectionDataSource createDriverManagerDataSourceBean()
	{
		SingleConnectionDataSource driverManager = new SingleConnectionDataSource();
		driverManager.setDriverClassName(environment.getProperty("driverClassName"));
		driverManager.setUrl(environment.getProperty("url"));
		driverManager.setUsername(environment.getProperty("username"));
		driverManager.setPassword(environment.getProperty("password"));
		return driverManager;
	}

}
