package com.alicankustemur.musicstore.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.model.Album;

@Component
public class AlbumRepositoryImpl implements AlbumRepository
{

	@Override
	public void save(Album album)
	{
		album.setSolded(true);
	}

	@Override
	public List<Album> getAllAlbumByArtistName(String artistName)
	{
		// VTODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByName(String name)
	{

	}

	@Override
	public Album getAlbumByName(String name)
	{
		// VTODO Auto-generated method stub
		return null;
	}

}
