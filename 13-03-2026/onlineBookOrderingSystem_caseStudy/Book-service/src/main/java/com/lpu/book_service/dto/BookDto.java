package com.lpu.book_service.dto;

public class BookDto {

	private int bookid;
	private int quantity;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int book_id) {
		this.bookid = book_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BookDto() {
		super();
	}
	
	
}
