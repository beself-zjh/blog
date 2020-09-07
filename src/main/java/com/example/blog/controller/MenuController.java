package com.example.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.blog.viewmodel.IndexViewModel;

@Controller
public class MenuController {
	
	@Autowired
	private IndexViewModel indexViewModel;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homeHandler(Model model) {
		model.addAttribute("ageOfSite", indexViewModel.getAgeOfSite());
		return "html/index";
	}
	
	@RequestMapping(path = "/category", method = RequestMethod.GET)
	public String category() {
		return "html/error";
	}

}
