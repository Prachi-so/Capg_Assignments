package com.lpu.book_service.controller;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.book_service.config.BookConfig;
import com.lpu.book_service.dto.BookDto;
import com.lpu.book_service.entity.Book;
import com.lpu.book_service.service.BookService;

@RestController
public class BookController {

	private BookService service;

	public BookController(BookService service) {
	
		this.service = service;
	}
	
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return service.addBook(book);
	}
	
	@GetMapping("/books")
	public List<Book> viewBooks(){
		return service.viewBook();
	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable int id, @RequestBody Book book) {
		return service.updateBook(book);
	}
	
	  @RabbitListener(queues = BookConfig.QUEUE_NAME)
	    public void receiveMessage(BookDto message) {

		 
	        System.out.println("Order received for Book ID: " + message.getBookid());

	        // Get book from DB
	        Book book = service.getBookById(message.getBookid());

	        if (book == null) {
	            System.out.println("Book not found in database!");
	            return;
	        }
	        // Reduce stock
	        book.setStock(book.getStock() - message.getQuantity());

	        // Save updated book
	        service.addBook(book);

	        System.out.println("Stock updated successfully");
	    }
}

