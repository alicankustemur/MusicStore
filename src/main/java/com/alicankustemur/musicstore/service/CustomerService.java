package com.alicankustemur.musicstore.service;

import com.alicankustemur.musicstore.model.Album;

public interface CustomerService
{
	public void saveCustomer(String name, String surname, Album album);
}
