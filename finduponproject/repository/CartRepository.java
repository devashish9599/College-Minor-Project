package com.finduponproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.finduponproject.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	
	
}
