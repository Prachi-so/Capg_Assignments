package com.lpu.book_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.book_service.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
