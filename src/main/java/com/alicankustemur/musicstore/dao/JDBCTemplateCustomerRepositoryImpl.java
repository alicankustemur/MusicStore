package com.alicankustemur.musicstore.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.model.Album;
import com.alicankustemur.musicstore.model.Customer;

@Component
public class JdbcTemplateCustomerRepositoryImpl extends JdbcDaoSupport implements CustomerRepository
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

		String sql = "INSERT INTO customer (name,surname,album_id) VALUES (?,?,?)";
		getJdbcTemplate().update(sql, customer.getName(), customer.getSurname(), customer.getAlbum().getId());
		// jdbcTemplate.queryForMap(sql,name);
		// jdbcTemplate.queryForList(sql);
	}

	private class CustomerExtractor implements ResultSetExtractor<Customer>
	{

		@Override
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

	@Override
	public int[] createBatchCustomer(final List<Customer> customers)
	{
		int[] updateCounts = getJdbcTemplate().batchUpdate("INSERT INTO customer (name,surname) VALUES (?,?) ",
				new BatchPreparedStatementSetter()
				{

					@Override
					public int getBatchSize()
					{
						return customers.size();
					}

					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException
					{
						Customer customer = customers.get(i);
						ps.setString(1, customer.getName());
						ps.setString(2, customer.getSurname());

					}
				});
		return updateCounts;

		/*
				List<Customer> customers = new ArrayList<Customer>();
				Customer customer1 = new Customer();
				customer1.setName("ali can");
				customer1.setSurname("kuştemur");
				Customer customer2 = new Customer();
				customer2.setName("özcan");
				customer2.setSurname("kuştemur");
				customers.add(customer1);
				customers.add(customer2);
				customerRepository.createRandomCustomer(customers);
		 * */
	}

	@Override
	public Customer getCustomerByName(String name)
	{

		return null;
	}

}
