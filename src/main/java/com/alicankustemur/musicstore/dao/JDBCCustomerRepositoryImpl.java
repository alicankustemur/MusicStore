package com.alicankustemur.musicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.model.Album;
import com.alicankustemur.musicstore.model.Customer;

@Component
public class JdbcCustomerRepositoryImpl extends JdbcDaoSupport implements CustomerRepository
{
	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void initialize()
	{
		setDataSource(dataSource);
	}

	@Override
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

	@Override
	public int[] createBatchCustomer(List<Customer> customer)
	{
		// VTODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByName(String name)
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Customer customer = new Customer();

		try
		{
			Connection connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE name = ?");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				customer.setId(resultSet.getLong("id"));
				customer.setName(resultSet.getString("name"));
				customer.setSurname(resultSet.getString("surname"));
				Album album = new Album();
				album.setId(resultSet.getLong("album_id"));
				customer.setAlbum(album);
			}
			resultSet.close();
			preparedStatement.close();

		}
		catch (Exception e)
		{
			// VTODO: handle exception
		}

		return customer;
	}

}
