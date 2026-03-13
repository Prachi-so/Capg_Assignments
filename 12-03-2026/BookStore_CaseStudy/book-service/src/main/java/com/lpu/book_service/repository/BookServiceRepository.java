package com.lpu.book_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.book_service.model.Book;

public interface BookServiceRepository extends JpaRepository<Book, Long> {

}
