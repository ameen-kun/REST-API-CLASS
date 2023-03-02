package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer>{
	
	public List<EmployeeModel> findByNameStartingWith(String prefix);
	
	public List<EmployeeModel> findByNameEndingWith(String suffix);
	
	public List<EmployeeModel> findNameByIdOrDept(long id,String dept);
	
	@Query("SELECT emp FROM EmployeeModel emp WHERE dept=?1")
	public List<EmployeeModel> findAllEmployeesByDept(String depart);
	@Modifying
	@Query("UPDATE EmployeeModel emp SET emp.salary=:sal WHERE emp.id=:id")
	public int updateEmployeeSalary(@Param("sal")double sal,@Param("id")long id);
	@Modifying
	@Query("DELETE FROM EmployeeModel emp WHERE emp.id=:id")
	public int deleteEmployeeDetails(@Param("id")long id);
}