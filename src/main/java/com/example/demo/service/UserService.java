package com.example.demo.service;

import java.util.List;

import com.example.demo.response.model.UserDetails;

public interface UserService {

	public List<UserDetails> getUsersList() throws Exception;
}
