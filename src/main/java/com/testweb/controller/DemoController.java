package com.testweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testweb.model.Human;
import com.testweb.repo.IHumanRepo;

@Controller
public class DemoController {
	
	@Autowired
	private IHumanRepo humanRepository;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue="World")String name, Model model) {
		
		Human human = new Human();
		human.setId(1);
		human.setName("James");
		humanRepository.save(human);
		
		model.addAttribute("name", name);
		return "greeting";
	}
	@GetMapping("/createList")
	public String greeting( Model model) {
		
		model.addAttribute("humans", humanRepository.findAll());
		return "greeting";
	}

}
