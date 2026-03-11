package com.lpu.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpu.User.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
}
