package com.alicankustemur.musicstore.model;

public class Album
{
	private long	id;
	private String	variation;
	private String	name;
	private String	artistName;
	private String	genre;
	private int		songNumbers;
	private boolean	solded;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getVariation()
	{
		return variation;
	}

	public void setVariation(String variation)
	{
		this.variation = variation;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getArtistName()
	{
		return artistName;
	}

	public void setArtistName(String artistName)
	{
		this.artistName = artistName;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public int getSongNumbers()
	{
		return songNumbers;
	}

	public void setSongNumbers(int songNumbers)
	{
		this.songNumbers = songNumbers;
	}

	public void setSolded(boolean solded)
	{
		this.solded = solded;
	}

	public boolean isSolded()
	{
		return solded;
	}

}
