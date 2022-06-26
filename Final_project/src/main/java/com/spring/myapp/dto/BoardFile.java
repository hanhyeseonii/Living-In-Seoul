package com.spring.myapp.dto;

public class BoardFile {
	private int bfnum;
	private int bnum;
	private String filename;
	public int getBfnum() {
		return bfnum;
	}
	public void setBfnum(int bfnum) {
		this.bfnum = bfnum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "BoardFile [bfnum=" + bfnum + ", bnum=" + bnum + ", filename=" + filename + "]";
	}
	
}
