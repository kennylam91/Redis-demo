package com.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentReporitory studentRepository;

	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getAll(){
		return (List<Student>) studentRepository.findAll();
	}
}
