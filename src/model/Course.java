package model;

import java.io.Serializable;

public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7456405971982568114L;
	private String courseTitle;
	private String courseNumber;
	private String courseDescritpion;
	private String textbookAssigned;
	private double numberOfCredits;
	
	public String getCourseDescritpion() {
		return courseDescritpion;
	}





	public void setCourseDescritpion(String courseDescritpion) {
		this.courseDescritpion = courseDescritpion;
	}





	public Course(String courseTitle, String courseNumber, String courseDescription, String textbookAssigned, String numberOfCredits) {
		super();
		this.courseTitle = courseTitle;
		this.courseNumber = courseNumber;
		this.courseDescritpion= courseDescription;
		this.textbookAssigned = textbookAssigned;
		this.numberOfCredits = Double.parseDouble(numberOfCredits);
	}
	
	



	@Override
	public String toString() {
		return "Course [courseTitle=" + courseTitle + ", courseNumber=" + courseNumber + ", textbookAssigned="
				+ textbookAssigned + ", numberOfCredits=" + numberOfCredits + "]";
	}





	public String getCourseTitle() {
		return courseTitle;
	}





	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}





	public String getTextbookAssigned() {
		return textbookAssigned;
	}





	public void setTextbookAssigned(String textbookAssigned) {
		this.textbookAssigned = textbookAssigned;
	}





	public double getNumberOfCredits() {
		return numberOfCredits;
	}





	public void setNumberOfCredits(double numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}





	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}





	public String getCourseNumber() {
		
		return courseNumber;
	}
	
	
}
