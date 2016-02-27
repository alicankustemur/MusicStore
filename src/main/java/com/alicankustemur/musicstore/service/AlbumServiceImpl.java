package com.alicankustemur.musicstore.service;

import com.alicankustemur.musicstore.dao.AlbumRepository;
import com.alicankustemur.musicstore.model.Album;

public class AlbumServiceImpl implements AlbumService
{
	private AlbumRepository albumRepository;

	public AlbumServiceImpl()
	{
		// VTODO Auto-generated constructor stub
	}

	public AlbumServiceImpl(AlbumRepository albumRepository)
	{
		super();
		this.albumRepository = albumRepository;
	}

	public AlbumRepository getAlbumRepository()
	{
		return albumRepository;
	}

	public void setAlbumRepository(AlbumRepository albumRepository)
	{
		this.albumRepository = albumRepository;
	}

	public Album sellAAlbum(String variation, String name, String artistName, String genre, int songNumbers)
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
