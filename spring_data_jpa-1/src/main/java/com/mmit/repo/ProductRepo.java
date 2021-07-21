package com.mmit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mmit.model.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.brand=:bname")
	List<Product> findByBrandName(@Param("bname") String bname);
}
