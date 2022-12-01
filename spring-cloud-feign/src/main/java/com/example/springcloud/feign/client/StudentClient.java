package com.example.springcloud.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springcloud.feign.dto.Student;

@FeignClient(name="STUDENT-API")
public interface StudentClient {

	@GetMapping("/students")
	 List<Student> getStudents();
	
	@GetMapping("/student/{id}")
	Student getStudent(@PathVariable("id") int id);
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student);
	
	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@PathVariable("id") int id,@RequestBody Student student);
	

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id);
																																																																																																																																																																																																																																				
	
	
	
}
