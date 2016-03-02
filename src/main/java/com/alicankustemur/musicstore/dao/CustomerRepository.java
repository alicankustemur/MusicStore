package com.alicankustemur.musicstore.dao;

import java.util.List;

import com.alicankustemur.musicstore.model.Customer;

public interface CustomerRepository
{
	public void save(Customer customer);

	public int[] createRandomCustomer(List<Customer> customer);
}
