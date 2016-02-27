package com.alicankustemur.musicstore.model;

public class Customer
{
	private String	name;
	private String	surname;
	private Album	album;

	public Customer()
	{
		// VTODO Auto-generated constructor stub
	}

	public Customer(String name, String surname, Album album)
	{
		super();
		this.name = name;
		this.surname = surname;
		this.album = album;
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