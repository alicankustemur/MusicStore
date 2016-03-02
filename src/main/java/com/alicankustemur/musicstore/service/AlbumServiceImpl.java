package com.alicankustemur.musicstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.dao.JdbcTemplateAlbumRepositoryImpl;
import com.alicankustemur.musicstore.model.Album;

@Component
public class AlbumServiceImpl implements AlbumService
{
	@javax.annotation.PostConstruct
	public void postConstruct()
	{
		System.out.println("hopbaaa");
	}

	@Autowired
	private JdbcTemplateAlbumRepositoryImpl albumRepository;

	public AlbumServiceImpl()
	{
		// VTODO Auto-generated constructor stub
	}

	public Album sellAAlbum(String name, String artistName, String variation, String genre, int songNumbers)
	{
		Album album = new Album();
		album.setVariation(variation);
		album.setName(name);
		album.setArtistName(artistName);
		album.setGenre(genre);
		album.setSongNumbers(songNumbers);
		albumRepository.save(album);
		return album;

	}

}
