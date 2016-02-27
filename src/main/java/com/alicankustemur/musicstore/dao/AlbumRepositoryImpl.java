package com.alicankustemur.musicstore.dao;

import java.util.List;

import com.alicankustemur.musicstore.model.Album;

public class AlbumRepositoryImpl implements AlbumRepository
{

	public void save(Album album)
	{
		album.setSolded(true);
	}

	public List<Album> getAllAlbumByArtistName(String artistName)
	{
		// VTODO Auto-generated method stub
		return null;
	}

	public void deleteByName(String name)
	{
		System.out.println("album deleted.");

	}

}
