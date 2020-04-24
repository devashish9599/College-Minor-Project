package com.finduponproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finduponproject.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByType(String type);
	
	Optional<Product> findById(Long id);
	

}
