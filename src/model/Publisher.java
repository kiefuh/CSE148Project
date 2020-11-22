package model;

import java.io.Serializable;

public class Publisher implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5433640382266364985L;
	String publisher;

	public Publisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String p) {
		this.publisher=p;
	}
	
	
}
