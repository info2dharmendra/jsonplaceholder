package com.example.demo.response.model;

import java.io.Serializable;

public class Geo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Geo() {}
	
	String lat;
	String lng;
	
	public Geo(String lat, String lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
}