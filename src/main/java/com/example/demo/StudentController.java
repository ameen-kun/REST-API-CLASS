package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class StudentController {
	@GetMapping("/")
	public String Homepage() {
		return "Welcome to student list";
	}
	@GetMapping("/list")
	public List<Student> getList(){
		List<Student> detailsL=new ArrayList<>();
		detailsL.add(new Student(1,"Hyundai",3));
		detailsL.add(new Student(2,"Suzuki",2));
		detailsL.add(new Student(3,"Nissan",1));
		detailsL.add(new Student(4,"Toyota",4));
		return detailsL;
	}
}
