package model;

import java.io.Serializable;

public abstract class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7800070090440255225L;
	private Name name;
	private String id;
	private String phoneNumber;
	private static int idCounter=1;
	
	/*public Person(Name name) {
		super();
		this.name=name;
		this.phoneNumber=emitARandomPhoneNumber();
		this.id=String.valueOf(idCounter++);
	}*/
	
	public Person (Name name, String phoneNumber) {
		super();
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.id=String.valueOf(idCounter++);
	}
	
	public Person (Name name, String phoneNumber,String id) {
		super();
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.id=id;
	}

	
	public String getIDNumber() {
		return id;
	}


	public Name getName() {
		return name;
	}


	public void setName(Name name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public static void setIdCounter(int idCount) {
		idCounter = idCount;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
	
	
	

	
	
	
}
