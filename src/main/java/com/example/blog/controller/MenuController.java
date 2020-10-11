package com.example.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.blog.viewmodel.ArticleViewModel;
import com.example.blog.viewmodel.CatalogViewModel;
import com.example.blog.viewmodel.LabelsViewModel;
import com.example.blog.viewmodel.NavigationViewModel;

@Controller
public class MenuController {
	
	@Autowired
	private NavigationViewModel navigationViewModel;
	
	@Autowired
	private ArticleViewModel articleViewModel;
	
	@Autowired
	private CatalogViewModel catalogViewModel;
	
	@Autowired
	private LabelsViewModel labelsViewModel;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homeHandler(Model model) {
		model.addAttribute("navigationViewModel", navigationViewModel.flush());
		
		return "html/index";
	}
	
	@RequestMapping(path = "/labels", method = RequestMethod.GET)
	public String labelsHandler(Model model) {
		model.addAttribute("navigationViewModel", navigationViewModel.flush());
		model.addAttribute("labelsViewModel", labelsViewModel.flush());
		
		return "html/labels";
	}
	
	@RequestMapping(path = "/catalog", method = RequestMethod.GET)
	public String catalogHandler(String label, Model model) {
		model.addAttribute("navigationViewModel", navigationViewModel.flush());
		model.addAttribute("catalogViewModel", catalogViewModel.flush(label));
		
		return "html/catalog";
	}
	
	@RequestMapping(path = "/article", method = RequestMethod.GET)
	public String articleHandler(@RequestParam String filename, Model model) {
		model.addAttribute("navigationViewModel", navigationViewModel.flush());
		model.addAttribute("articleViewModel", articleViewModel.flush(filename));
		
		return "html/article";
	}

}
