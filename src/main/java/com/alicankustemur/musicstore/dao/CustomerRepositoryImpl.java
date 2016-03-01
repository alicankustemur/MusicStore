package com.alicankustemur.musicstore.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.alicankustemur.musicstore.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository
{

	private DataSource			dataSource;
	private SimpleJdbcInsert	insertCustomer;

	public DataSource getDataSource()
	{
		return dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
		insertCustomer = new SimpleJdbcInsert(dataSource).withTableName("customer");
	}

	public void save(Customer customer)
	{
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("name", customer.getName());
		parameters.put("surname", customer.getSurname());
		parameters.put("album_id", customer.getAlbum().getId());
		insertCustomer.execute(parameters);

	}

}
