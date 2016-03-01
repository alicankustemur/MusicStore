package com.alicankustemur.musicstore.dao;

import java.util.List;

import com.alicankustemur.musicstore.model.Album;

public interface AlbumRepository
{
	public void save(Album album);

	public void deleteByName(String name);

	public List<Album> getAllAlbumByArtistName(String artistName);

	public Album getAlbumByName(String name);

}
