package com.alicankustemur.musicstore.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.alicankustemur.musicstore.dao.AlbumRepository;
import com.alicankustemur.musicstore.dao.AlbumRepositoryImpl;
import com.alicankustemur.musicstore.dao.JDBCAlbumRepositoryImpl;
import com.alicankustemur.musicstore.dao.JDBCCustomerRepositoryImpl;
import com.alicankustemur.musicstore.dao.JDBCTemplateAlbumRepositoryImpl;
import com.alicankustemur.musicstore.dao.JDBCTemplateCustomerRepositoryImpl;
import com.alicankustemur.musicstore.service.AlbumService;
import com.alicankustemur.musicstore.service.AlbumServiceImpl;

@Configuration
@Import({DatabaseConfiguration.class})
public class BeanConfiguration
{

	@Inject
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
		AlbumServiceImpl albumService = new AlbumServiceImpl();
		albumService.setAlbumRepository(createAlbumRepositoryBean());
		return albumService;
	}

	@Bean
	public JDBCAlbumRepositoryImpl createJDBCAlbumRepositoryImplBean()
	{
		JDBCAlbumRepositoryImpl jdbcAlbum = new JDBCAlbumRepositoryImpl();
		jdbcAlbum.setDataSource(databaseConfiguration.createDriverManagerDataSourceBean());
		return jdbcAlbum;
	}

	@Bean
	public JDBCCustomerRepositoryImpl createJDBCCustomerRepositoryImplBean()
	{
		JDBCCustomerRepositoryImpl jdbcCustomer = new JDBCCustomerRepositoryImpl();
		jdbcCustomer.setDataSource(databaseConfiguration.createDriverManagerDataSourceBean());
		return jdbcCustomer;
	}

	@Bean
	public JDBCTemplateCustomerRepositoryImpl createJDBCTemplateCustomerRepositoryImpl()
	{
		JDBCTemplateCustomerRepositoryImpl jdbcCustomerTemplate = new JDBCTemplateCustomerRepositoryImpl(
				databaseConfiguration.createDriverManagerDataSourceBean());
		return jdbcCustomerTemplate;
	}

	@Bean
	public JDBCTemplateAlbumRepositoryImpl createJDBCTemplateAlbumRepositoryImpl()
	{
		JDBCTemplateAlbumRepositoryImpl jdbcAlbumTemplate = new JDBCTemplateAlbumRepositoryImpl(
				databaseConfiguration.createDriverManagerDataSourceBean());
		return jdbcAlbumTemplate;
	}

}
