package com.example.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {
	
	//The three options for RestTemplate requests are ForEntity, ForObject, and exchange
	@GetMapping("/getForEntity")
	public ResponseEntity<String> restTemplateGetForEntity(){
		//What ForEntity will essentially return a string
		//So some singular entity
		RestTemplate rest = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		ResponseEntity<String> res = rest.getForEntity(url, String.class);
		return res;
	}
	
	//The next option for creating requests is ForObject()
	@PostMapping("/postForObject")
	public GenericPost restTemplatePostForObject(@RequestBody GenericPost p) {
		RestTemplate rest = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		HttpEntity<GenericPost> request = new HttpEntity<GenericPost>(p);
		return rest.postForObject(url, request, GenericPost.class);
		
	}
	
	//The final option for making requests in Java is with exchange
	@PostMapping("/exchange")
	public GenericPost restTemplateExchange(@RequestBody GenericPost p) {
		RestTemplate rest = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		HttpEntity<GenericPost> request = new HttpEntity<GenericPost>(p);
		return rest.exchange(url, HttpMethod.POST, request, GenericPost.class).getBody();
	}

}

class GenericPost{
	private int id;
	private String title;
	private String body;
	private int userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
