package com.alicankustemur.musicstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.alicankustemur.musicstore.model.Album;

@Component
public class JdbcTemplateAlbumRepositoryImpl extends JdbcDaoSupport implements AlbumRepository
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
		Album dbAlbum = getAlbumByName(album.getName());

		if (dbAlbum == null)
		{
			String sql = "INSERT INTO album (name,artist_name,variation,genre,song_numbers) VALUES (?,?,?,?,?)";
			getJdbcTemplate().update(sql, album.getName(), album.getArtistName(), album.getVariation(),
					album.getGenre(), album.getSongNumbers());
			album.setSolded(true);

		}

	}

	@Override
	public List<Album> getAllAlbumByArtistName(String artistName)
	{
		ResultSetExtractor<Album> albumExtractor = new AlbumExtractor();
		String sql = "SELECT * FROM album WHERE artist_name = ? ";
		return getJdbcTemplate().query(sql, new Object[] {artistName}, new AlbumMapper());
	}

	@Override
	public void deleteByName(String name)
	{
		// VTODO Auto-generated method stub

	}

	@Override
	public Album getAlbumByName(String name)
	{
		String sql = "SELECT * FROM album WHERE name = ? ";
		try
		{
			Album album = getJdbcTemplate().queryForObject(sql, new AlbumRowMapper(), name);
			return album;
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}

	}

	private class AlbumExtractor implements ResultSetExtractor
	{
		@Override
		public Album extractData(ResultSet rs) throws SQLException, DataAccessException
		{
			Album album = new Album();
			album.setId(rs.getLong("id"));
			album.setName(rs.getString("name"));
			album.setArtistName(rs.getString("artist_name"));
			album.setVariation(rs.getString("variation"));
			album.setGenre(rs.getString("genre"));
			album.setSongNumbers(rs.getInt("song_numbers"));
			System.out.println(album.getId());
			return album;
		}
	}

	private class AlbumMapper implements RowMapper
	{

		@Override
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
		return album;

	}

	private class AlbumRowMapper implements RowMapper<Album>
	{

		@Override
		public Album mapRow(ResultSet rs, int rowNum) throws SQLException
		{

			return mapAlbum(rs);
		}

	}

}
