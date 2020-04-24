package com.finduponproject.service;

import java.util.List;

import com.finduponproject.model.Product;

public interface ProductService {

	List<Product> findByType(String type);
	
	
	

}
