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

public class JDBCTemplateAlbumRepositoryImpl implements AlbumRepository
{
	private JdbcTemplate jdbcTemplate;

	public JDBCTemplateAlbumRepositoryImpl(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(Album album)
	{
		// VTODO Auto-generated method stub

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

}
