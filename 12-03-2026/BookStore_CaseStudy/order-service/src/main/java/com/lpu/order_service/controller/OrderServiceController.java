package com.lpu.order_service.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.order_service.FeignClientForBook;
import com.lpu.order_service.model.BookDto;
import com.lpu.order_service.model.Order;
import com.lpu.order_service.repository.OrderServiceRepository;

@RequestMapping("/api")
@RestController
public class OrderServiceController {
	@Autowired
	private OrderServiceRepository repo;
	
	@Autowired
	private FeignClientForBook feignClient;
	
	@GetMapping("/orders")
	public List<Order> allOrders(){
		return repo.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public Order findOrderById(@PathVariable Long id) {
		return repo.findById(id).orElse(null);
	}
	
	@PostMapping("/orders")
	public Order newOrder(@RequestBody Order order) {
		BookDto book= feignClient.findBookById(order.getBookid());
		
		Double total=book.getPrice()*order.getQuantity();
		order.setTotalPrice(total);
		order.setStatus("PLACED");
		order.setOrderDate(LocalDate.now());
		
		return repo.save(order);
		
	}
	
	@PutMapping("/orders/{id}")
	public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
		return repo.save(order);
	}
	
	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable Long id) {
		 repo.deleteById(id);
	}
	
	//FEIGN CLIENT
	
	@GetMapping("/findbook/{id}")
	public BookDto findBookByOrder(@PathVariable Long id) {
		return feignClient.findBookById(id);
	}
	
	@GetMapping("/getbooks")
	public List<BookDto> getAllBooks() {
		return feignClient.allBooks();
	}
	
	@PostMapping("/savebook")
	public BookDto saveBook(@RequestBody BookDto book) {
		return feignClient.creatBook(book);
	}
	
	@PutMapping("/updatebook/{id}")
	public BookDto updateBook(  @RequestBody BookDto book, @PathVariable Long id) {
		return feignClient.updateBookById( book, id);
	}
	
	@DeleteMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable Long id) {
		 feignClient.deleteBookById(id);
		 return "book deleted";
	}
}

