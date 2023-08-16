package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Student;
import com.example.Repository.StudentRepository;

@RestController
@RequestMapping("/stud")
public class StudentController 
{
	@Autowired
	private StudentRepository repo;
	
	@PostMapping
	public Student savestudent(@RequestBody Student student)
	{
		return repo.save(student); 
	}
	
	@GetMapping("/get")
	public List<Student> getallstudents()
	{
		return repo.findAll();
	}
	
	@GetMapping("/g")
	public Student getstudent(@RequestParam Long id)
	{
		return repo.findById(id).get();
	}
	
	@PutMapping
	public Student updatestudent(@RequestBody Student student)
	{
		return repo.save(student); 
	}
	
	@DeleteMapping("/d")
	public String deletestudent(@RequestParam Long id)
	{
		repo.deleteById(id);
		return "deleted successfully";
	}
}
