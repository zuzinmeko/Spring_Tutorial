package com.mmit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmit.model.CityRepo;
import com.mmit.model.Customer;
import com.mmit.model.Customer.Gender;
import com.mmit.model.CustomerRepo;

@Controller
@RequestMapping("customers")
public class CustomerController {
	//injex same
	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private CityRepo cityRepo;
	
	@GetMapping
	public String home(ModelMap model) {
		model.addAttribute("customers",repo.findAll());
		
		return "home";
	}
	@GetMapping("add")
	public String addCustomer(ModelMap model) {
		//model.addAttribute("customer",new Customer());
		//model.addAttribute("cities",cityRepo.getCities());
		model.addAttribute("genders",Gender.values());
		return "add";
	}
	@PostMapping("save")
	public String saveCustomer(Customer cust) {
		
		repo.save(cust);
		return "redirect:/customers";
	}
	
	@ModelAttribute("customer")
	public Customer customer() {
		return new Customer();
	}
	@ModelAttribute("cities")
	public List<String> cities(){
		return cityRepo.getCities();
	}
}
