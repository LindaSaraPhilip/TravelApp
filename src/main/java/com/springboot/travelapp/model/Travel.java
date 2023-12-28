package com.springboot.travelapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Travel_tbl")
public class Travel {
	
	public Travel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private Long travelid;
	private String name;
	private String email;
	private Long mobile;
	private String destination;
	private String descp;
	@Override
	public String toString() {
		return "Travel [travelid=" + travelid + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", destination=" + destination + ", descp=" + descp + ", price=" + price + "]";
	}
	public Long getTravelid() {
		return travelid;
	}
	public Travel(long i, String name, String email, Long mobile, String destination, String descp, int price) {
		super();
		this.travelid = i;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.destination = destination;
		this.descp = descp;
		this.price = price;
	}
	public void setTravelid(Long travelid) {
		this.travelid = travelid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int price;
	
	

}
