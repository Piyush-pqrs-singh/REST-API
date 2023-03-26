package net.pi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.pi.bean.Student;

@RestController
@RequestMapping("/piyush")
public class StudentController {

	
	//{id} URI template variable
	@GetMapping("/getmen/{id}")
	public Student studentPathVariable(@PathVariable("id")  Long id) {
		Student s1=new Student(id,"Piyush","Singh");
		return s1;
	}
	
	@GetMapping("/getmen/{id}/{first-name}/{last-name}")
	public Student studentPathVariable1(@PathVariable("id")  Long id,@PathVariable("first-name") String firstName,@PathVariable("last-name") String lastName) {
		Student s1=new Student(id,firstName,lastName); 
		return s1;
	}
	
}
