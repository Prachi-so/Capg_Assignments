package com.lpu.order_service.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false) 
	private Long bookid;
	
	@Column(nullable=false) 
	private String customerName;
	
	@Column(nullable=false) 
	private Integer quantity;
	
	@Column
	private Double totalPrice;
	
	@Column
	private String status;
	
	@Column
	private LocalDate orderDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Order() {
		super();
	}

	public Order(Long bookid, String customerName, Integer quantity, Double totalPrice, String status,
			LocalDate orderDate) {
		super();
		this.bookid = bookid;
		this.customerName = customerName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.orderDate = orderDate;
	}
	
	
}
