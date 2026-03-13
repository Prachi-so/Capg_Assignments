package com.lpu.order_service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.lpu.order_service.model.BookDto;



@FeignClient("BOOK-SERVICE")
public interface FeignClientForBook {
	
	@GetMapping("/api/books/{id}")
	public BookDto findBookById(@PathVariable Long id);
	
	@PostMapping("/api/savebooks")
	public BookDto creatBook(@RequestBody BookDto book);

	@GetMapping("/api/books")
	public List<BookDto> allBooks();
	
	@PutMapping("/api/books/{id}")
	public BookDto updateBookById( @RequestBody BookDto book, @PathVariable Long id);
	
	@DeleteMapping("/api/books/{id}")
	public void deleteBookById(@PathVariable Long id);
}
