package com.example.StudentAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.StudentAPI.Student;
import com.example.StudentAPI.dao.StudentRepo;

@RestController
public class MyController {
	
	@Autowired
	private StudentRepo repo;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return repo.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentBYId(@PathVariable("id") int id)
	{
		return repo.findById(id).orElse(null);
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student)
	{
		return repo.save(student);
	}
	
	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@PathVariable("id") int id,@RequestBody Student student)
	{
		Student s=repo.findById(id).orElse(null);
		if(s!=null)
		{
			if(student.getName()!=null)
				s.setName(student.getName());
			if(student.getAddress()!=null)
				s.setAddress(student.getAddress());
			if(student.getPhone()!=null)
				s.setPhone(student.getPhone());
			return repo.save(s);
		}
		else
			return repo.save(student);
			
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id)
	{
		Student s=repo.findById(id).orElse(null);
		if(s==null)
			return "student is not exists with given id";
		else
		{
			repo.deleteById(id);
			return "deleted successfully";
		}
	}
	
	@Autowired
	@Lazy
	private RestTemplate template;
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
/*	@Value("${insurance.provider.url}")
	private String url;
	
	@GetMapping("/getPlan")
	public List<String> getPlans()
	{
		List<String> plans=template.getForObject(url,List.class);
		return plans;
	}*/

	@Value("${message}")
	private String msg;
	@GetMapping("/getMsg")
	public String getmsg()
	{
		return msg;
	}
	

}
