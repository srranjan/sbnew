package com.mypoc.rest;

import java.io.Serializable;



public class MyClient2 implements Serializable {
    
	

    public MyClient2() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Long id;
	private String name;
	private String phone;
	private String address;
	private String potalCd;
	private String type;
	private String balance;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPotalCd() {
		return potalCd;
	}
	public void setPotalCd(String potalCd) {
		this.potalCd = potalCd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

	
    
    
}

