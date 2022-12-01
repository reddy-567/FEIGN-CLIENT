package com.example.collegeapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.collegeapi.dto.CollegeRepo;
import com.example.collegeapi.models.College;

@RestController
public class MyController {
	
	private CollegeRepo repo;
	
	@GetMapping("colleges")
	public List<College> getColleges() {
		return repo.findAll();
		
	}
	
	@GetMapping("college/{id}")
	public College getCollege(@PathVariable("id") int id)
	{
		return repo.findById(id).orElse(null);
	}
	
	@PostMapping("addCollege")
	public College addCollege(@RequestBody College clg)
	{
		return repo.save(clg);
	}
	
	@PutMapping("updateCollege/{id}")
	public College update(@PathVariable("id") int id,@RequestBody College clg)
	{
		return repo.save(clg);
	}
	
	@DeleteMapping("deleteCollege/{id}")
	public String delte(@PathVariable("id") int id)
	{
		College c=repo.findById(id).orElse(null);
		if(c!=null)
		{
		repo.deleteById(id);
		return "deleted..";
		}
		else
			return "college not exists with given id";
	}
	
	

}
