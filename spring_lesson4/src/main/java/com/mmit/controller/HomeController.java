package com.mmit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public String index() {
		return "home";
	}
	@GetMapping("string")
	public String stringReturnType(ModelMap model) {
		model.addAttribute("message","This is string return type.");
		return "string";
	}
	
	@GetMapping("modelandview")
	public ModelAndView modelandview(ModelMap model) {
		model.addAttribute("message","this is model and view");
		ModelAndView mv=new ModelAndView("model-view");
		return mv;
		
	}
	@GetMapping("noreturn")
	public void noreturn(ModelMap model) {
		model.put("message", "This is no return type");
		
	}
}
