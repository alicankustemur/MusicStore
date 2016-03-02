package com.alicankustemur.musicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.model.Customer;

@Component
public class JdbcCustomerRepositoryImpl implements CustomerRepository
{
	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public void save(Customer customer)
	{
		PreparedStatement preparedStatement = null;

		try
		{
			Connection connection = dataSource.getConnection();
			preparedStatement = connection
					.prepareStatement("INSERT INTO customer (name,surname,album_id) VALUES (?,?,?)");
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getSurname());
			preparedStatement.setLong(3, customer.getAlbum().getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();

		}
		catch (Exception e)
		{
			// VTODO: handle exception
		}

	}

	public int[] createRandomCustomer(List<Customer> customer)
	{
		// VTODO Auto-generated method stub
		return null;
	}

}
