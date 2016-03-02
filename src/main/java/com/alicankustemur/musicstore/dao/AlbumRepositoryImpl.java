package com.alicankustemur.musicstore.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.model.Album;

@Component
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

	public Album getAlbumByName(String name)
	{
		// VTODO Auto-generated method stub
		return null;
	}

}
