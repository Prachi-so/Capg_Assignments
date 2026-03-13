package com.lpu.order_service.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.order_service.config.RabbitConfig;

import com.lpu.order_service.dto.BookDto;
import com.lpu.order_service.entity.Order;
import com.lpu.order_service.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repo;

	private final RabbitTemplate rabbitTemplate;

	public OrderService(RabbitTemplate rabbitTemplate) {
	
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public Order createOrder(Order order) {
		order.setStatus("CREATED");
		
		Order savedOrder=repo.save(order);
        // send message to RabbitMQ
        BookDto message = new BookDto(savedOrder.getBookid(), savedOrder.getQuantity());
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, message);
        
		return savedOrder;
	}
	
	public List<Order> viewOrder(){
		return repo.findAll();
	}
	
	
	
	
	
	
}
