package com.spring.myapp.dto;

public class FavoriteBikeStation {
	private String email;
	private String stationId;
	private String stationLatitude;
	private String stationLongitude;
	public FavoriteBikeStation(String email, String stationId, String stationLatitude, String stationLongitude) {
		super();
		this.email = email;
		this.stationId = stationId;
		this.stationLatitude = stationLatitude;
		this.stationLongitude = stationLongitude;
	}
	public FavoriteBikeStation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getStationLatitude() {
		return stationLatitude;
	}
	public void setStationLatitude(String stationLatitude) {
		this.stationLatitude = stationLatitude;
	}
	public String getStationLongitude() {
		return stationLongitude;
	}
	public void setStationLongitude(String stationLongitude) {
		this.stationLongitude = stationLongitude;
	}
	@Override
	public String toString() {
		return "FavoriteBikeStation [email=" + email + ", stationId=" + stationId + ", stationLatitude="
				+ stationLatitude + ", stationLongitude=" + stationLongitude + "]";
	}
}
