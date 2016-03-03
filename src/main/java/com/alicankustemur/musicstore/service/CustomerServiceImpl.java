package com.alicankustemur.musicstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.dao.JdbcCustomerRepositoryImpl;
import com.alicankustemur.musicstore.model.Album;
import com.alicankustemur.musicstore.model.Customer;

@Component
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	private JdbcCustomerRepositoryImpl repository;

	@Override
	public void saveCustomer(String name, String surname, Album album)
	{
		Customer customer = new Customer();
		customer.setName(name);
		customer.setSurname(surname);
		customer.setAlbum(album);
		repository.save(customer);
		System.out.println(name + " customer saved.");
	}

}
