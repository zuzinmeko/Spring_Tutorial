package com.mmit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmit.model.entity.Product;
import com.mmit.repo.ProductRepo;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepo repo;

	public void save(Product p) {
		repo.save(p);
		
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Product findById(Integer id) {
		
		return repo.findById(id).get();
	}

	public void remove(int id) {
		repo.deleteById(id);
		
	}

	public List<Product> findByBrandName(String brandName) {
		
		return repo.findByBrandName(brandName);
	}
}
