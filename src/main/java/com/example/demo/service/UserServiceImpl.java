package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;
import com.example.demo.response.model.UserDetails;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("restTemplate")
	RestTemplate restTemplate;

	@Override
	public List<UserDetails> getUsersList() throws Exception {
		
		String url= "https://jsonplaceholder.typicode.com/users";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<User[]> usersList = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User[].class);
		
		List<UserDetails> tempUsersList = new ArrayList<UserDetails>();
		
		if(usersList.getStatusCode().is2xxSuccessful()) {
			User[] listOfUsers = usersList.getBody();
			
			for (User user : listOfUsers) {
				UserDetails userDetail = new UserDetails(user.getId(), user.getAddress().getGeo());
				tempUsersList.add(userDetail);
			}
		}
		return tempUsersList;
	}

}
