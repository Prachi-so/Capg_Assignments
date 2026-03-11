package com.lpu.User.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lpu.User.ProductFeignClient;
import com.lpu.User.Entity.Product;
import com.lpu.User.Entity.User;
import com.lpu.User.repository.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepo repo;
	
	//interface object
	@Autowired
	private ProductFeignClient client;
	
	@GetMapping("/save")
	public String saveUser() {
		System.err.println("hiiiiiiiii");
		return "User saved";
	}
	
	@PostMapping("/saveuser")
	public User saveUser2(@RequestBody User user) {
		
		return repo.save(user);
	}
	
	@GetMapping("/data")
	public String userData() {
		System.err.println("hiiiiiiiii");
		return "data from user service";
	}
	
	@GetMapping("/test")
	public String test(){
	    return "User Service Working";
	}
	
	@GetMapping("/fetch/{id}")
	public Optional<User> fetchById(@PathVariable int  id) {
		return repo.findById(id);
	}
	
	//fetching products from user
	@GetMapping("/getproducts")
	public String getProductinUser() {
		return client.fetchdata();
	}
	
	//sending data from user to product using feign
	//url-http://localhost:8087/user/saveinproducts
	@PostMapping("saveinproducts")
	public Product sendDataFromUserToProduct(@RequestBody Product product) {
		return client.saveProduct(product);
	}
	
	//sending data from user to product using rest template
	@PostMapping("/send")
	public Product sendDataFromUserServiceToProduct(@RequestBody Product product) {
		String url = "http://localhost:8067/product/save";
	    RestTemplate template = new RestTemplate();
	    Product response = template.postForObject(url, product, Product.class);
	    return response;
	}
	
}
