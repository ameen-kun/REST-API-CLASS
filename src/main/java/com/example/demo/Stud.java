package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stud {
	@Id
private int id;
private String name;
private int ranks;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getRanks() {
	return ranks;
}
public void setRanks(int ranks) {
	this.ranks = ranks;
}
public Stud() {
	super();
	// TODO Auto-generated constructor stub
}
public Stud(int id, String name, int ranks) {
	super();
	this.id = id;
	this.name = name;
	this.ranks = ranks;
}

}
