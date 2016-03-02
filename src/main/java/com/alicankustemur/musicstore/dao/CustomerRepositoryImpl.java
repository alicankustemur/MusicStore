package com.alicankustemur.musicstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.model.Customer;

@Component
public class CustomerRepositoryImpl implements CustomerRepository
{

	private DataSource			dataSource;
	private SimpleJdbcInsert	insertCustomer;

	@Autowired
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

	public int[] createRandomCustomer(List<Customer> customer)
	{
		// VTODO Auto-generated method stub
		return null;
	}

}
