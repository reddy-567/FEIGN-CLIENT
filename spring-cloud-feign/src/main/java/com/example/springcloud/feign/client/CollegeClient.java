package com.example.springcloud.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springcloud.feign.dto.College;

@FeignClient(name="COLLEGE-API")
public interface CollegeClient {
	
	@GetMapping("/colleges")
	public List<College> getColleges() ;
	
	@GetMapping("/college/{id}")
	public College getCollege(@PathVariable("id") int id);
	
	@PostMapping("/addCollege")
	public College addCollege(@RequestBody College clg);
	
	@PutMapping("/updateCollege/{id}")
	public College update(@PathVariable("id") int id,@RequestBody College clg);
	
	@DeleteMapping("/deleteCollege/{id}")
	public String delte(@PathVariable("id") int id);

}
