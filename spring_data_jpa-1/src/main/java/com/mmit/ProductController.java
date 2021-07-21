package com.mmit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmit.model.entity.Product;
import com.mmit.service.ProductService;

@Controller

public class ProductController {
		@Autowired
		private ProductService service;
		
	@GetMapping("/")
	public String index(ModelMap model) {
		List<Product> list=service.findAll();
		model.addAttribute("products",list);
		return "home";
	}
	@GetMapping("/product-add")
	public String addProdudct(ModelMap model) {
		model.addAttribute("product",new Product());
		return "product-add";
	}
	
	
	@PostMapping("/save")
	public String saveProduct(Product product) {
		service.save(product);
		return "redirect:/";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id")int id,ModelMap model) {
		model.addAttribute("product",service.findById(id));
		return "product-add";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		service.remove(id);
		return "redirect:/";
	}
	@PostMapping("/search")
	public String SearchProduct(@RequestParam("name")String brandName,ModelMap model) {
		List<Product> list=brandName != null && !brandName.isEmpty() ? service.findByBrandName(brandName) : service.findAll();
		model.addAttribute("products",list);
		model.addAttribute("bname",brandName);
		return "home";
	}
}
