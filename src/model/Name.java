package model;

import java.io.Serializable;

public class Name implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 439501463506898728L;
	private String firstName;
	private String lastName;
	
	public Name(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}
	
	public Name(Name name) {
		this.firstName=name.firstName;
		this.lastName=name.lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName ;
	}
	
	public String toStringExport() {
		return firstName+"|"+lastName;
	}
	
	
	
	
}
