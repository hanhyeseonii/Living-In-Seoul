package com.spring.myapp.dto;

public class Seoul {

	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Seoul [location=" + location + "]";
	}
	
}
