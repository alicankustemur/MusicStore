package com.alicankustemur.musicstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.alicankustemur.musicstore.dao.AlbumRepository;
import com.alicankustemur.musicstore.dao.AlbumRepositoryImpl;
import com.alicankustemur.musicstore.dao.CustomerRepositoryImpl;
import com.alicankustemur.musicstore.dao.JdbcAlbumRepositoryImpl;
import com.alicankustemur.musicstore.dao.JdbcCustomerRepositoryImpl;
import com.alicankustemur.musicstore.dao.JdbcTemplateAlbumRepositoryImpl;
import com.alicankustemur.musicstore.dao.JdbcTemplateCustomerRepositoryImpl;
import com.alicankustemur.musicstore.service.AlbumService;
import com.alicankustemur.musicstore.service.AlbumServiceImpl;
import com.alicankustemur.musicstore.service.CustomerService;
import com.alicankustemur.musicstore.service.CustomerServiceImpl;

@Configuration
@Import({DatabaseConfiguration.class})
public class BeanConfiguration
{

	@Autowired
	private DatabaseConfiguration databaseConfiguration;

	public BeanConfiguration()
	{
		// VTODO Auto-generated constructor stub
	}

	@Bean
	public AlbumRepository createAlbumRepositoryBean()
	{
		return new AlbumRepositoryImpl();
	}

	@Bean
	public AlbumService createAlbumServiceBean()
	{
		AlbumServiceImpl service = new AlbumServiceImpl();
		service.setAlbumRepository(createJDBCTemplateAlbumRepositoryImplBean());
		return service;
	}

	@Bean
	public CustomerService createCustomerServiceBean()
	{
		CustomerServiceImpl service = new CustomerServiceImpl();
		service.setRepository(createJDBCTemplateCustomerRepositoryImplBean());
		return service;
	}

	@Bean
	public JdbcAlbumRepositoryImpl createJDBCAlbumRepositoryImplBean()
	{
		JdbcAlbumRepositoryImpl repository = new JdbcAlbumRepositoryImpl();
		repository.setDataSource(databaseConfiguration.createDriverManagerDataSourceBean());
		return repository;
	}

	@Bean
	public JdbcCustomerRepositoryImpl createJDBCCustomerRepositoryImplBean()
	{
		JdbcCustomerRepositoryImpl repository = new JdbcCustomerRepositoryImpl();
		repository.setDataSource(databaseConfiguration.createDriverManagerDataSourceBean());
		return repository;
	}

	@Bean
	public JdbcTemplateCustomerRepositoryImpl createJDBCTemplateCustomerRepositoryImplBean()
	{
		JdbcTemplateCustomerRepositoryImpl repository = new JdbcTemplateCustomerRepositoryImpl(
				databaseConfiguration.createDriverManagerDataSourceBean());
		return repository;
	}

	@Bean
	public JdbcTemplateAlbumRepositoryImpl createJDBCTemplateAlbumRepositoryImplBean()
	{
		JdbcTemplateAlbumRepositoryImpl repository = new JdbcTemplateAlbumRepositoryImpl(
				databaseConfiguration.createDriverManagerDataSourceBean());
		return repository;
	}

	@Bean
	public CustomerRepositoryImpl createCustomerRepositoryImplBean()
	{
		CustomerRepositoryImpl repository = new CustomerRepositoryImpl();
		repository.setDataSource(databaseConfiguration.createDriverManagerDataSourceBean());
		return repository;
	}

}
