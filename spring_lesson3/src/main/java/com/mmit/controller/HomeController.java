package com.mmit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "home";
	}
	
	/*
	 * @GetMapping("/demo/{name}") public String pathVariable(@PathVariable String
	 * name,ModelMap model) { model.put("result", "Hello"+name);
	 * //model.addAttribute("result","Hello"+name); return "home"; }
	 */
	
	@GetMapping("/demo/{name}")
	public String pathVariable(@PathVariable(value="name") int na,ModelMap model) {
		model.put("result", "Hello"+na);
		//model.addAttribute("result","Hello"+name);
		return "home";
	}
	
	@GetMapping("/demo/query")
	public String queryParameter(ModelMap model, @RequestParam String name,@RequestParam int age) {
		model.addAttribute("result","Hello "+name+" Your age"+age);
		return "home";
	}
}
