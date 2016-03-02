package com.alicankustemur.musicstore.model;

public class Customer
{
	private long	id;
	private String	name;
	private String	surname;
	private Album	album;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public Album getAlbum()
	{
		return album;
	}

	public void setAlbum(Album album)
	{
		this.album = album;
	}

	@Override
	public String toString()
	{
		return "Customer [name=" + name + ", surname=" + surname + ", album=" + album + "]";
	}

}
