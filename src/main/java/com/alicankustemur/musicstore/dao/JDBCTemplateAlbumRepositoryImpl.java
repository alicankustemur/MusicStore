package com.alicankustemur.musicstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.alicankustemur.musicstore.model.Album;

public class JdbcTemplateAlbumRepositoryImpl implements AlbumRepository
{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplateAlbumRepositoryImpl(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(Album album)
	{
		String sql = "INSERT INTO album (name,artist_name,variation,genre,song_numbers) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, album.getName(), album.getArtistName(), album.getVariation(), album.getGenre(),
				album.getSongNumbers());
	}

	public List<Album> getAllAlbumByArtistName(String artistName)
	{
		ResultSetExtractor<Album> albumExtractor = new AlbumExtractor();
		String sql = "SELECT id,name,artist_name,variation,genre,song_numbers FROM album WHERE artist_name = ? ";
		return jdbcTemplate.query(sql, new Object[] {artistName}, new AlbumMapper());
	}

	public void deleteByName(String name)
	{
		// VTODO Auto-generated method stub

	}

	public Album getAlbumByName(String name)
	{
		String sql = "SELECT id,name,artist_name,variation,genre,song_numbers FROM album WHERE name = ? ";
		return jdbcTemplate.queryForObject(sql, new AlbumRowMapper(), name);

	}

	private class AlbumExtractor implements ResultSetExtractor
	{
		public Album extractData(ResultSet rs) throws SQLException, DataAccessException
		{
			Album album = new Album();
			album.setId(rs.getLong("id"));
			album.setName(rs.getString("name"));
			album.setArtistName(rs.getString("artist_name"));
			album.setVariation(rs.getString("variation"));
			album.setGenre(rs.getString("genre"));
			album.setSongNumbers(rs.getInt("song_numbers"));
			System.out.println(rs.getString("artist_name") + "albums returned.");
			return album;
		}
	}

	private class AlbumMapper implements RowMapper
	{

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			AlbumExtractor extractor = new AlbumExtractor();
			return extractor.extractData(rs);
		}

	}

	private Album mapAlbum(ResultSet rs) throws SQLException
	{
		Album album = new Album();
		album.setId(rs.getInt("id"));
		album.setName(rs.getString("name"));
		album.setArtistName(rs.getString("artist_name"));
		album.setVariation(rs.getString("variation"));
		album.setGenre(rs.getString("genre"));
		album.setSongNumbers(rs.getInt("song_numbers"));
		System.out.println(rs.getString("name") + " album returned.");
		return album;

	}

	private class AlbumRowMapper implements RowMapper<Album>
	{

		public Album mapRow(ResultSet rs, int rowNum) throws SQLException
		{

			return mapAlbum(rs);
		}

	}

}
