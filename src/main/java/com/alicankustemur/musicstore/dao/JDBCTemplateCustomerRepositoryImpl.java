package com.alicankustemur.musicstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.alicankustemur.musicstore.model.Album;
import com.alicankustemur.musicstore.model.Customer;

public class JdbcTemplateCustomerRepositoryImpl implements CustomerRepository
{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplateCustomerRepositoryImpl(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Customer customer)
	{
		String sql = "INSERT INTO customer (name,surname,album_id) VALUES (?,?,?)";
		jdbcTemplate.update(sql, customer.getName(), customer.getSurname(), customer.getAlbum().getId());
		// jdbcTemplate.queryForMap(sql,name);
		// jdbcTemplate.queryForList(sql);
	}

	private class CustomerExtractor implements ResultSetExtractor<Customer>
	{

		public Customer extractData(ResultSet rs) throws SQLException, DataAccessException
		{
			return null;
		}

	}

	private Customer mapCustomer(ResultSet resultSet) throws SQLException
	{
		Customer customer = null;
		if (resultSet.next())
		{
			customer.setName(resultSet.getString("name"));
			customer.setSurname(resultSet.getString("surname"));
			Album album = new Album();
			album.setId(resultSet.getLong("album_id"));
			customer.setAlbum(album);
		}
		if (customer == null)
		{
			throw new EmptyResultDataAccessException(1);
		}

		return customer;
	}

}
