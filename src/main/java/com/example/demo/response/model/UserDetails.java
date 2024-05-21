package com.example.demo.response.model;

import java.io.Serializable;

import com.example.demo.model.Geo;

public class UserDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String id;
	Geo geo;
	
	public UserDetails(String id, Geo geo) {
		super();
		this.id = id;
		this.geo = geo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

}


