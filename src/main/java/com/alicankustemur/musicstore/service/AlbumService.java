package com.alicankustemur.musicstore.service;

import com.alicankustemur.musicstore.model.Album;

public interface AlbumService
{
	public Album sellAAlbum(String variation, String name, String artistName, String genre, int songNumbers);
}
