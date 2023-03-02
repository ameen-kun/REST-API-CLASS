package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;

import jakarta.transaction.Transactional;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	@GetMapping("/get/namebyprefix/{prefix}")
	public List<EmployeeModel>getNameByPrefix(@PathVariable("prefix") String prefix){
		return service.getByNameStartingWith(prefix);
	}
	@GetMapping("/or/{id}/{dept}")
	public List<EmployeeModel>getNameByOr(@PathVariable long id,String dept){
		return service.findNameByOr(id,dept);
	}
	@GetMapping(value="/getbydept/{dept}")
	public List<EmployeeModel> getBydept(@PathVariable("dept")String dept){
		return service.findEmpByDept(dept);
	}
	@GetMapping("/")
	public List<EmployeeModel> getAllEmp(){
		return service.getAll();
	}
	@PutMapping("/updatesalary/{sal}/{id}")
	public String putEmployeeSalary(@PathVariable double sal,@PathVariable long id) {
		String res="";
		int r=service.updateEmployeeSalary(sal, id);
		if(r>0) {
			res="Salary updated"+r;
			System.err.println(res);
		}
		else {
			res="Salary not updated"+r;
			System.err.println(res);
		}
		return res;
	}
	@DeleteMapping("/del/{id}")
	public String delEmployeeDetails(@PathVariable long id) {
		int r=service.deleteEmployeeDetails(id);
		String res="";
		if(r>0) {
			res="Deleted"+r;
			System.err.println(res);
		}
		else {
			res="Not Deleted"+r;
			System.err.println(res);
		}
		return res;
	}
}