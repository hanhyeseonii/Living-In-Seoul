package com.spring.myapp.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private String email;
	private String name;
	private String passwd;
	private String birthdate;
	private String address;
	private String simplejoin;
	private Date regidate;
	private Date modidate;
	
	public Member() {
		super();
	}

	public Member(String email, String name, String passwd, String birthdate, String address, String simplejoin,
			Date regidate, Date modidate) {
		super();
		this.email = email;
		this.name = name;
		this.passwd = passwd;
		this.birthdate = birthdate;
		this.address = address;
		this.simplejoin = simplejoin;
		this.regidate = regidate;
		this.modidate = modidate;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public String getAddress() {
		return address;
	}

	public String getSimplejoin() {
		return simplejoin;
	}

	public Date getRegidate() {
		return regidate;
	}

	public Date getModidate() {
		return modidate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setSimplejoin(String simplejoin) {
		this.simplejoin = simplejoin;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", name=" + name + ", passwd=" + passwd + ", birthdate=" + birthdate
				+ ", address=" + address + ", simplejoin=" + simplejoin + ", regidate=" + regidate + ", modidate="
				+ modidate + "]";
	}

	
	
}
