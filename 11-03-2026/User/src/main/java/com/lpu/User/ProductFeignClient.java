package com.lpu.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lpu.User.Entity.Product;



//to represent product controller

@FeignClient("PRODUCT")
public interface ProductFeignClient {

	//this is abstract nethod, the implementation is in product controller
	  @GetMapping("/product/getdata")
	   public String fetchdata();
	  
	  @PostMapping("/product/save")
	    public Product saveProduct(@RequestBody Product product) ;
}
