package com.lpu.order_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.order_service.entity.Order;
import com.lpu.order_service.service.OrderService;

@RestController
public class OrderController {

	private OrderService service;

	public OrderController(OrderService service) {
		
		this.service = service;
	}
	
	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order order) {
		
		return service.createOrder(order);
	}
	
	@GetMapping("/orders")
	public List<Order> viewOrders(){
		return service.viewOrder();
	}
	
	
}
