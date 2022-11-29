package com.addbook.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	String name;
	String Address;
	String city;
	int pincode;
	String phoneno;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public static boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setUserid(int id2) {
		// TODO Auto-generated method stub
		
	}

	public static boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
