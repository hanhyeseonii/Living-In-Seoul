package com.spring.myapp.dto;

public class BikeStation {
	private String stationId;
	private String roadaddress;
	private String detailaddress;
	private double stationLatitude;
	private double stationLongitude;
	public BikeStation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BikeStation(String stationId, String roadaddress, String detailaddress, double stationLatitude,
			double stationLongitude) {
		super();
		this.stationId = stationId;
		this.roadaddress = roadaddress;
		this.detailaddress = detailaddress;
		this.stationLatitude = stationLatitude;
		this.stationLongitude = stationLongitude;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getRoadaddress() {
		return roadaddress;
	}
	public void setRoadaddress(String roadaddress) {
		this.roadaddress = roadaddress;
	}
	public String getDetailaddress() {
		return detailaddress;
	}
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	public double getStationLatitude() {
		return stationLatitude;
	}
	public void setStationLatitude(double stationLatitude) {
		this.stationLatitude = stationLatitude;
	}
	public double getStationLongitude() {
		return stationLongitude;
	}
	public void setStationLongitude(double stationLongitude) {
		this.stationLongitude = stationLongitude;
	}
	@Override
	public String toString() {
		return "BikeStation [stationId=" + stationId + ", roadaddress=" + roadaddress + ", detailaddress="
				+ detailaddress + ", stationLatitude=" + stationLatitude + ", stationLongitude=" + stationLongitude
				+ "]";
	}
}
