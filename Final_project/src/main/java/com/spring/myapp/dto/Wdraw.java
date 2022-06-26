package com.spring.myapp.dto;

import java.util.Date;

public class Wdraw {
	private Date wdrawdate;
	private String email;
	private String wdrawrs;
	private String passwd;
	
	public Wdraw() {
		super();
	}

	public Wdraw(Date wdrawdate, String email, String wdrawrs, String passwd) {
		super();
		this.wdrawdate = wdrawdate;
		this.email = email;
		this.wdrawrs = wdrawrs;
		this.passwd = passwd;
	}

	public Date getWdrawdate() {
		return wdrawdate;
	}

	public String getEmail() {
		return email;
	}

	public String getWdrawrs() {
		return wdrawrs;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setWdrawdate(Date wdrawdate) {
		this.wdrawdate = wdrawdate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWdrawrs(String wdrawrs) {
		this.wdrawrs = wdrawrs;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "Wdraw [wdrawdate=" + wdrawdate + ", email=" + email + ", wdrawrs=" + wdrawrs + ", passwd=" + passwd
				+ "]";
	}


	
}
