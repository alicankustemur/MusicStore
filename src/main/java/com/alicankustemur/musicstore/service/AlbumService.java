package com.alicankustemur.musicstore.service;

import com.alicankustemur.musicstore.model.Album;

public interface AlbumService
{
	public Album sellAAlbum(String name, String artistName, String variation, String genre, int songNumbers);
}
