package com.fot.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;


public class Address implements Serializable {

	String apt;
	String streetName;
	String city;
	String state;
	String zipCode;
	
	public Address(){
		
	}
	
	public Address(String apt,String streetName,String city,String state,String zipCode){
		super();
		this.apt = apt;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public String getFullAddress(){
		return apt+","+streetName+","+city+","+state+"-"+zipCode;
	}
	
	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	

}
