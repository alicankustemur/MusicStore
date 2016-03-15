package com.alicankustemur.musicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.model.Album;

@Component
public class JdbcAlbumRepositoryImpl extends JdbcDaoSupport implements AlbumRepository
{

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void initialize()
	{
		setDataSource(dataSource);
	}

	@Override
	public void save(Album album)
	{
		PreparedStatement preparedStatement = null;
		try
		{
			Connection connection = dataSource.getConnection();
			// public Album sellAAlbum(String variation, String name, String artistName, String genre, int songNumbers);
			preparedStatement = connection.prepareStatement(
					"INSERT INTO album (name,artist_name,variation,genre,song_numbers) VALUES (?,?,?,?,?) ");
			preparedStatement.setString(1, album.getName());
			preparedStatement.setString(2, album.getArtistName());
			preparedStatement.setString(3, album.getVariation());
			preparedStatement.setString(4, album.getGenre());
			preparedStatement.setInt(5, album.getSongNumbers());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException e)
		{
			// VTODO Auto-generated catch block
			e.printStackTrace();
		}

		album.setSolded(true);

	}

	@Override
	public List<Album> getAllAlbumByArtistName(String artistName)
	{
		List<Album> albums = new ArrayList<Album>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try
		{
			Connection connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(
					"SELECT id,name,artist_name,variation,genre,song_numbers FROM album WHERE artist_name = ? ");
			preparedStatement.setString(1, artistName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				Album album = new Album();
				album.setId(resultSet.getLong(1));
				album.setName(resultSet.getString(2));
				album.setArtistName(resultSet.getString(3));
				album.setVariation(resultSet.getString(4));
				album.setGenre(resultSet.getString(5));
				album.setSongNumbers(resultSet.getInt(6));
				albums.add(album);
			}
			resultSet.close();
			preparedStatement.close();
		}
		catch (Exception e)
		{
			// VTODO: handle exception
		}
		return albums;
	}

	@Override
	public void deleteByName(String name)
	{
		PreparedStatement preparedStatement = null;
		try
		{
			Connection connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM album WHERE name = ?");
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Album getAlbumByName(String name)
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Album album = new Album();
		try
		{
			Connection connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM album WHERE name = ?");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				album.setArtistName(resultSet.getString("artist_name"));
				album.setName(resultSet.getString("name"));
				album.setId(resultSet.getLong("id"));
				album.setGenre(resultSet.getString("genre"));
				album.setSongNumbers(resultSet.getInt("song_numbers"));
				album.setVariation(resultSet.getString("variation"));
			}
			resultSet.close();
			preparedStatement.close();
		}
		catch (Exception e)
		{
			// VTODO: handle exception
		}

		return album;
	}

}
