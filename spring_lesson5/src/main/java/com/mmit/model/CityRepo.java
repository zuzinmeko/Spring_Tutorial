package com.mmit.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CityRepo {
	
	private List<String> cities;
	public CityRepo() {
		cities=new ArrayList<String>();
	}
	
	public List<String> getCities(){
		cities=List.of("Yangon","Mandalay","Bago");
		return cities;
	}
}
