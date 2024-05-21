package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class UsersProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersProjApplication.class, args);
	}
	
	@Bean("restTemplate")
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate ppsRestTemplate = builder.build();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        ppsRestTemplate.getMessageConverters().add(0, converter);
		return ppsRestTemplate;
	}

}
