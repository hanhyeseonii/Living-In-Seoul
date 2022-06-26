package com.spring.myapp.dto;

public class Tourism {
	private int tnum;
	private String tname;
	private String taddress;
	private String taddress_new;
	private String phone;
	private String site;
	private String use_time;
	private String bsnde;
	private String rstde;
	private String subway_info;
	private String tag;
	private String BF_DESC;
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTaddress() {
		return taddress;
	}
	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}
	public String getTaddress_new() {
		return taddress_new;
	}
	public void setTaddress_new(String taddress_new) {
		this.taddress_new = taddress_new;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getUse_time() {
		return use_time;
	}
	public void setUse_time(String use_time) {
		this.use_time = use_time;
	}
	public String getBsnde() {
		return bsnde;
	}
	public void setBsnde(String bsnde) {
		this.bsnde = bsnde;
	}
	public String getRstde() {
		return rstde;
	}
	public void setRstde(String rstde) {
		this.rstde = rstde;
	}
	public String getSubway_info() {
		return subway_info;
	}
	public void setSubway_info(String subway_info) {
		this.subway_info = subway_info;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getBF_DESC() {
		return BF_DESC;
	}
	public void setBF_DESC(String bF_DESC) {
		BF_DESC = bF_DESC;
	}
	@Override
	public String toString() {
		return "tourism [tnum=" + tnum + ", tname=" + tname + ", taddress=" + taddress + ", taddress_new="
				+ taddress_new + ", phone=" + phone + ", site=" + site + ", use_time=" + use_time + ", bsnde=" + bsnde
				+ ", rstde=" + rstde + ", subway_info=" + subway_info + ", tag=" + tag + ", BF_DESC=" + BF_DESC + "]";
	}
	
}