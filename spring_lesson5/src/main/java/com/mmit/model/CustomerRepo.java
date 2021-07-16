package com.mmit.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("application")
public class CustomerRepo {
	
	private List<Customer> list;
	
	public CustomerRepo() {
		list=new ArrayList<Customer>();
	}
	
	public List<Customer> findAll(){
		return list;
		
	}
	
	public void save(Customer customer) {
		list.add(customer);
	}
}
