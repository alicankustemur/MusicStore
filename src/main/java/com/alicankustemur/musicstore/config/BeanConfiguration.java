package com.alicankustemur.musicstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.alicankustemur.musicstore")
@Import({DatabaseConfiguration.class})
public class BeanConfiguration
{

	@Autowired
	private DatabaseConfiguration databaseConfiguration;

	public BeanConfiguration()
	{
		// VTODO Auto-generated constructor stub
	}

}
