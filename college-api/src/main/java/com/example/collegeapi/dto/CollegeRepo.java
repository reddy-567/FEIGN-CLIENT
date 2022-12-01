package com.example.collegeapi.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.collegeapi.models.College;

public interface CollegeRepo extends JpaRepository<College,Integer>{
	

}
