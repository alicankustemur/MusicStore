package com.alicankustemur.musicstore;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alicankustemur.musicstore.config.BeanConfiguration;
import com.alicankustemur.musicstore.service.AlbumService;

public class Main
{

	public static void main(String[] args) throws SQLException
	{

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		AlbumService albumService = applicationContext.getBean(AlbumService.class);
		albumService.sellAAlbum("The Wall", "lksadklasd", "sadaksldlka", "saldalkd", 123);

	}

}
