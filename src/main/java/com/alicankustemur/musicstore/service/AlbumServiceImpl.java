package com.alicankustemur.musicstore.service;

import com.alicankustemur.musicstore.dao.JdbcTemplateAlbumRepositoryImpl;
import com.alicankustemur.musicstore.model.Album;

public class AlbumServiceImpl implements AlbumService
{
	private JdbcTemplateAlbumRepositoryImpl albumRepository;

	public AlbumServiceImpl()
	{
		// VTODO Auto-generated constructor stub
	}

	public JdbcTemplateAlbumRepositoryImpl getAlbumRepository()
	{
		return albumRepository;
	}

	public void setAlbumRepository(JdbcTemplateAlbumRepositoryImpl albumRepository)
	{
		this.albumRepository = albumRepository;
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
