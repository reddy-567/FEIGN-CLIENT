package com.example.springcloud.feign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcloud.feign.client.CollegeClient;
import com.example.springcloud.feign.client.ConfigServerClient;
import com.example.springcloud.feign.client.StudentClient;
import com.example.springcloud.feign.dto.College;
import com.example.springcloud.feign.dto.Student;

@RestController
public class FeignController {
	
	@Autowired
	private StudentClient studentclient;
	
	@Autowired
	private ConfigServerClient configserverclient;
	
	@Autowired
	private CollegeClient collegeclient;
	
	@GetMapping("/feign-students")
	public List<Student> getStudents()
	{
		return studentclient.getStudents();
	}
	
	@GetMapping("/feign-student/{id}")
	public Student getStudent(@PathVariable("id") int id)
	{
		return studentclient.getStudent(id);
	}
	
	@PostMapping("/feign-addStudent")
	public Student addStudent(@RequestBody Student student)
	{
		return studentclient.addStudent(student);
	}
	
	@PutMapping("/feign-updateStudent/{id}")
	public Student updateStudent(@PathVariable("id") int id,@RequestBody Student student)
	{
		return studentclient.updateStudent(id, student);
	}

	@DeleteMapping("/feign-deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id)
	{
		return studentclient.deleteStudent(id);
	}
	
	@GetMapping("/demo")
	public String demo()
	{
		return configserverclient.demo();
	}
	
	@PostMapping("/feign-addCollege")
	public College addCollege(@RequestBody College college)
	{
		return collegeclient.addCollege(college);
	}

	@GetMapping("/feign-getCollege/{id}")
	public College get(@PathVariable("id") int id)
	{
		return collegeclient.getCollege(id);
	}
	@GetMapping("/feign-getColleges")
	public List<College> getAll()
	{
		return collegeclient.getColleges();
	}
	
	@PutMapping("/feign-updateColleges/{id}")
	public College update(@PathVariable("id") int id,@RequestBody College clg)
	{
		return collegeclient.update(id, clg);
	}
	
	@DeleteMapping("/feign-deleteCollege/{id}")
	public String delete(@PathVariable("id") int id)
	{
		return collegeclient.delte(id);
	}
	
}



