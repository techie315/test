package com.micro.service.third.dto;

public class User {
	String name;
	String surname;
	
	public User() {
		super();
	}
	
	public User(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return  name + " " + surname;
	}
}