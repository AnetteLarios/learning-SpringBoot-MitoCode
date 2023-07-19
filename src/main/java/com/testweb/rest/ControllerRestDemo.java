package com.testweb.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import com.testweb.model.Human;
import com.testweb.repo.IHumanRepo;

@RestController
@RequestMapping("/jsonOperations")
public class ControllerRestDemo {
	
	@Autowired
	private IHumanRepo humanRepo;
	
	@GetMapping
	public List<Human> createList(){
		return humanRepo.findAll();
	}
	@PostMapping
	public void insertIntoDatabase(@RequestBody Human human) {
		humanRepo.save(human);
	}
	@PutMapping
	public void modifyAll(@RequestBody Human human) {
		humanRepo.save(human);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteAll(@PathVariable("id")int id) {
		humanRepo.deleteById(id);
	}
}