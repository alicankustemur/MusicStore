package com.alicankustemur.musicstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.dao.JdbcTemplateAlbumRepositoryImpl;
import com.alicankustemur.musicstore.model.Album;

@Component
public class AlbumServiceImpl implements AlbumService
{

	@Autowired
	private JdbcTemplateAlbumRepositoryImpl albumRepository;

	@Override
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

	@Override
	public Album getAlbumByName(String name)
	{
		Album album = new Album();
		album = albumRepository.getAlbumByName(name);
		return album;
	}

}
