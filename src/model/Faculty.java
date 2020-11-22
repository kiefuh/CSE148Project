package model;

import java.io.Serializable;

public class Faculty  extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8847367131619700118L;
	private Title title;
	private double salary;
	
	public Faculty(Name name, Title title,String phoneNumber) {
		super(name,phoneNumber);
		this.title = title;
		this.salary = emitRandomSalary();
	}
	
	public Faculty(Name name, Title title,String phoneNumber,double salary) {
		super(name,phoneNumber);
		this.title = title;
		this.salary = salary;
	}
	
	public Faculty(Name name, Title title,String phoneNumber,double salary,String id) {
		super(name,phoneNumber,id);
		this.title = title;
		this.salary = salary;
	}
	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	
	public double emitRandomSalary() {
		double salary= (10000+(Math.random()*90000));
		return salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
}
