package com.spring.myapp.dto;

public class RealTimeStationInfo {
	private String stationName;
	private String rackTotCnt;
	private String parkingBikeTotCnt;
	private String shared;
	private String stationLatitude;
	private String stationLongitude;
	private String stationId;
	public RealTimeStationInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RealTimeStationInfo(String stationName, String rackTotCnt, String parkingBikeTotCnt, String shared,
			String stationLatitude, String stationLongitude, String stationId) {
		super();
		this.stationName = stationName;
		this.rackTotCnt = rackTotCnt;
		this.parkingBikeTotCnt = parkingBikeTotCnt;
		this.shared = shared;
		this.stationLatitude = stationLatitude;
		this.stationLongitude = stationLongitude;
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getRackTotCnt() {
		return rackTotCnt;
	}
	public void setRackTotCnt(String rackTotCnt) {
		this.rackTotCnt = rackTotCnt;
	}
	public String getParkingBikeTotCnt() {
		return parkingBikeTotCnt;
	}
	public void setParkingBikeTotCnt(String parkingBikeTotCnt) {
		this.parkingBikeTotCnt = parkingBikeTotCnt;
	}
	public String getShared() {
		return shared;
	}
	public void setShared(String shared) {
		this.shared = shared;
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
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	@Override
	public String toString() {
		return "RealTimeStationInfo [stationName=" + stationName + ", rackTotCnt=" + rackTotCnt + ", parkingBikeTotCnt="
				+ parkingBikeTotCnt + ", shared=" + shared + ", stationLatitude=" + stationLatitude
				+ ", stationLongitude=" + stationLongitude + ", stationId=" + stationId + "]";
	}
}
