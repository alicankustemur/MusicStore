package com.alicankustemur.musicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.alicankustemur.musicstore.model.Customer;

public class JDBCCustomerRepositoryImpl implements CustomerRepository
{
	private DataSource dataSource;

	public DataSource getDataSource()
	{
		return dataSource;
	}

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

}
