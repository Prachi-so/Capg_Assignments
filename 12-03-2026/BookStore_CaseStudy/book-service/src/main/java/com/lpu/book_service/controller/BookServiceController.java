package com.lpu.book_service.controller;

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

import com.lpu.book_service.model.Book;
import com.lpu.book_service.repository.BookServiceRepository;

@RequestMapping("/api")
@RestController
public class BookServiceController {
	@Autowired
	private BookServiceRepository repo;
	
	@PostMapping("/savebooks")
	public Book creatBook(@RequestBody Book book) {
		return repo.save(book);
	}
	
	@GetMapping("/books")
	public List<Book> allBooks(){
		return repo.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Book findBookById(@PathVariable Long id) {
		return repo.findById(id).orElse(null);
	}
	
	@PutMapping("/books/{id}")
	public Book updateBookById( @RequestBody Book book, @PathVariable Long id) {
		return repo.save(book);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBookById(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
