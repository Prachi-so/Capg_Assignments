package com.lpu.book_service.service;

import java.util.List;


import org.springframework.stereotype.Service;


import com.lpu.book_service.entity.Book;
import com.lpu.book_service.repository.BookRepository;

@Service
public class BookService {

	private BookRepository repo;

	public BookService(BookRepository repo) {
		
		this.repo = repo;
	}
	
	public Book addBook(Book book) {
		return repo.save(book);
	}
	
	public List<Book> viewBook(){
		return repo.findAll();
	}
	
	public Book updateBook(Book book) {
		return repo.save(book);
	}

	public Book getBookById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	
	
}
