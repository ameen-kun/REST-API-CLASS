package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class StudService {
@Autowired
StudRepository Repo;


public Optional<Stud> getStud(int id){
	return Repo.findById(id);
}

public String updateDetails(int id,Stud stu) {
	if(Repo.existsById(id)) {
	Stud temp=new Stud();
	temp.setId(id);
	temp.setName(stu.getName());
	temp.setRanks(stu.getRanks());
	Repo.save(temp);
	return "Updated";
	}
	return "Invalid";
}
public String deleteDetails(int id) {
	if(Repo.existsById(id)) {
	Repo.deleteById(id);
	return "Deleted";
	}
	return "Invalid";
}
public List<Stud> setPages(@PathVariable int offset,@PathVariable int PageSize){
	Page<Stud> page= Repo.findAll(PageRequest.of(offset, PageSize));
	return page.getContent();
}
public List<Stud> getSort(String field){
	return Repo.findAll(Sort.by(Sort.Direction.ASC,field));
}

}
