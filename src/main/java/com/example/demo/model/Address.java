package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class Address {
	
	public Address() {}
	
	String street;
	String suite;
	String city;
	String zipcode;
	
	@JsonProperty("geo")
	Geo geo;

	public Address(Geo geo) {
		super();
		this.geo = geo;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}
	
}