package com.lpu.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.order_service.model.Order;

public interface OrderServiceRepository extends JpaRepository<Order,Long>{

}
