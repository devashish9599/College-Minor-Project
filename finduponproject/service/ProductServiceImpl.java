package com.finduponproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.finduponproject.model.Product;
import com.finduponproject.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productR;
	
	


	@Override
	public List<Product> findByType(String type) {
		// TODO Auto-generated method stub
		return productR.findByType(type);
	}

	
	
}
