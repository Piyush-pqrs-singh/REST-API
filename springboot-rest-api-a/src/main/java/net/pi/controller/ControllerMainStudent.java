package net.pi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import net.pi.bean.Student;

@RequestMapping("main")
@RestController
public class ControllerMainStudent {
    //REST API That Handle HTTP POST REQUEST
    //@POST MAPPING AND @REQUEST BODY
    //@RequestBody Internally used  Spring provided HttpMessageConverter to convert JSON into Java Object
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String createStudent(@RequestBody Student student) {
    	System.out.println(student.getFirstName());
    	System.out.println(student.getLastName());
    	System.out.println(student.getId());
    	return "Done";
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id){
        Student student = new Student(
          id,
          "Ramesh",
          "Fadatare"
        );
        
        return ResponseEntity.status(HttpStatus.OK)
                .header("custom-header", "Singh")
                .contentType(MediaType.APPLICATION_JSON)             
                .body(student);
        
		/*
		  return ResponseEntity.ok() 
		     .header("custom-header", "Singh")
		     .contentType(MediaType.APPLICATION_JSON) .body(student);
		 */
    }
    
    // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/main/1/ramesh/fadatare
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") Long studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    
    // Spring boot REST API with Request Param
    //  http://localhost:8080/main/query?id=1&firstName=Ramesh&lastName=Fadatare
    @GetMapping("/query")
    public ResponseEntity<?> retrunRequestParam(@RequestParam(name="id",required = true) Long id,
    		@RequestParam(name="name",required = false)String firstName,@RequestParam(name="last",required = false)String lastName) {
    	 Student student = new Student( id, firstName, lastName );
    	return ResponseEntity.status(HttpStatus.OK)
                .header("custom-header", "Singh")
                .contentType(MediaType.APPLICATION_JSON)             
                .body(student);
    	
    }
	

}
