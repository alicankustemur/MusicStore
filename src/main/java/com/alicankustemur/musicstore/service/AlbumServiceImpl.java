package com.alicankustemur.musicstore.service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.dao.JdbcTemplateAlbumRepositoryImpl;
import com.alicankustemur.musicstore.model.Album;

@Component
public class AlbumServiceImpl extends JdbcDaoSupport implements AlbumService
{

	@Autowired
	private JdbcTemplateAlbumRepositoryImpl	albumRepository;

	@Autowired
	private DataSource						dataSource;

	@PostConstruct
	public void initialize()
	{
		setDataSource(dataSource);
	}

	@Override
	public Album sellAAlbum(String name, String artistName, String variation, String genre, int songNumbers)
	{

		Album dbAlbum = getAlbumByName(name);
		Album album = new Album();

		if (dbAlbum == null)
		{
			album.setVariation(variation);
			album.setName(name);
			album.setArtistName(artistName);
			album.setGenre(genre);
			album.setSongNumbers(songNumbers);
			album.setSolded(true);
			albumRepository.save(album);

		}
		else
		{
			System.out.println(dbAlbum.getName() + " is already exists in database.");
		}

		return album;

	}

	@Override
	public Album getAlbumByName(String name)
	{
		Album album = new Album();
		album = albumRepository.getAlbumByName(name);
		if (album != null)
		{
			System.out.println(album.getName() + " album returned.");
		}
		return album;
	}

}
