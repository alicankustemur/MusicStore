package com.alicankustemur.musicstore;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alicankustemur.musicstore.config.BeanConfiguration;
import com.alicankustemur.musicstore.dao.JdbcTemplateAlbumRepositoryImpl;
import com.alicankustemur.musicstore.model.Album;
import com.alicankustemur.musicstore.service.CustomerService;

public class Main
{

	public static void main(String[] args) throws SQLException
	{

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		JdbcTemplateAlbumRepositoryImpl albumRepository = applicationContext
				.getBean(JdbcTemplateAlbumRepositoryImpl.class);
		CustomerService customerService = applicationContext.getBean(CustomerService.class);

		Album album = albumRepository.getAlbumByName("Bayramın Olsun");
		customerService.saveCustomer("Özcan", "Kuştemur", album);

	}

}
