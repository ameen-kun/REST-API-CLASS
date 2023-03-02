package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class StudController {
@Autowired
	StudRepository serviceRepo;
@Autowired
	StudService service;
@GetMapping("/getvals")
public  List<Stud> getList(){
	return serviceRepo.findAll();
}
@PostMapping("/post")
public Stud create(@RequestBody Stud stu) {
	return serviceRepo.save(stu);
}
@GetMapping("/get/{id}")
public Optional<Stud> get(@PathVariable int id){
	return service.getStud(id);
}
@PutMapping("/put/{id}")
public String update(@PathVariable int id,@RequestBody Stud stu) {
	return service.updateDetails(id,stu);
}
@DeleteMapping("/del")
public String delete(@RequestParam int id) {
	return service.deleteDetails(id);
}
@GetMapping("/getsorted/{field}")
public List<Stud> studSort(@PathVariable String field){
	return service.getSort(field);
}
@GetMapping("/p/{offset}/{PageSize}")
public List<Stud> studentWithPagination(@PathVariable int offset,@PathVariable int PageSize){
	return service.setPages(offset,PageSize);
	
}
}
