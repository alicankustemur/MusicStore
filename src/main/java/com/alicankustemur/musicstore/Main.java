package com.alicankustemur.musicstore;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alicankustemur.musicstore.config.BeanConfiguration;
import com.alicankustemur.musicstore.dao.JDBCAlbumRepositoryImpl;
import com.alicankustemur.musicstore.dao.JDBCCustomerRepositoryImpl;
import com.alicankustemur.musicstore.model.Album;
import com.alicankustemur.musicstore.model.Customer;

public class Main
{

	public static void main(String[] args) throws SQLException
	{

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);

		JDBCAlbumRepositoryImpl jdbcAlbum = applicationContext.getBean(JDBCAlbumRepositoryImpl.class);
		JDBCCustomerRepositoryImpl jdbcCustomer = applicationContext.getBean(JDBCCustomerRepositoryImpl.class);
		Customer customer = new Customer();
		customer.setName("Ali Can");
		customer.setSurname("Kuştemur");
		List<Album> albums = jdbcAlbum.getAllAlbumByArtistName("Pink Floyd");

		for (Album album : albums)
		{
			customer.setAlbum(album);
			break;
		}

		jdbcCustomer.save(customer);

	}

}
