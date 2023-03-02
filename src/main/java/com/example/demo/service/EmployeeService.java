package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
	public List<EmployeeModel> getByNameStartingWith(String prefix){
		return repo.findByNameStartingWith(prefix);
	}
	public List<EmployeeModel> findNameByOr(long id,String dept){
		return repo.findNameByIdOrDept(id,dept);
	}
	public List<EmployeeModel> findEmpByDept(String d){
		return repo.findAllEmployeesByDept(d);
	}
	@Transactional
	public int updateEmployeeSalary(double sal,long id) {
		int result=repo.updateEmployeeSalary(sal, id);
		return result;
	}
	@Transactional
	public int deleteEmployeeDetails(long id) {
		int delres=repo.deleteEmployeeDetails(id);
		return delres;
	}
	public List<EmployeeModel> getAll(){
		return repo.findAll();
	}
}