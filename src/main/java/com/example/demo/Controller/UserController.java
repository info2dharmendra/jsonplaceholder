package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.model.UserDetails;
import com.example.demo.service.UserService;


@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	

	@GetMapping(path = "/getUser",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDetails> getUsers() throws Exception {
		
		List<UserDetails> usersList = new ArrayList<UserDetails>();
		try {
			usersList = userService.getUsersList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to retrieve user details");
			
		}
		return usersList;
	}

}
