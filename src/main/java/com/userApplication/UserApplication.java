package com.userApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(UserApplication.class, args);
		RestTemplate restTemplate= new RestTemplate();
		restTemplate.getForEntity(new URI("http://localhost:8081/api/user/setupRep"), String.class);
	}

}
