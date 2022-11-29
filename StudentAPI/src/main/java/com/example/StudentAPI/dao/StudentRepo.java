package com.example.StudentAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentAPI.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{

}
