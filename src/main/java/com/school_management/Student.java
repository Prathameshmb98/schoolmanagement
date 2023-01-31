package com.school_management;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Student {
	@Id
	private int id;
	private String name;
	private String branch;
	private double fees;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
	

}
