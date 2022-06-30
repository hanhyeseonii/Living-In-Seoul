package com.spring.myapp.dto;

import java.util.Date;

public class Accident {
	private int accId;
	private String accInfo;
	private Date regidate;
	
	public Accident() {
		super();
	}
	
	public Accident(int accId, String accInfo, Date regidate) {
		super();
		this.accId = accId;
		this.accInfo = accInfo;
		this.regidate = regidate;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getAccInfo() {
		return accInfo;
	}

	public void setAccInfo(String accInfo) {
		this.accInfo = accInfo;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "Accident [accId=" + accId + ", accInfo=" + accInfo + ", regidate=" + regidate + "]";
	}
	
	
}
