package com.alicankustemur.musicstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.model.Album;

@Component
public class JdbcAlbumRepositoryImpl implements AlbumRepository
{

	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public void save(Album album)
	{
		PreparedStatement preparedStatement = null;
		try
		{
			// public Album sellAAlbum(String variation, String name, String artistName, String genre, int songNumbers);
			Connection connection = dataSource.getConnection();
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

	}

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

	public Album getAlbumByName(String name)
	{
		// VTODO Auto-generated method stub
		return null;
	}

}
