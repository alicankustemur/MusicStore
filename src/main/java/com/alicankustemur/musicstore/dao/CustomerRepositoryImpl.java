package com.alicankustemur.musicstore.dao;

import com.alicankustemur.musicstore.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository
{

	public void save(Customer customer)
	{
		System.out.println("customer saved.");
	}

}
