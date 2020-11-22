package model;

import java.io.Serializable;

import javafx.scene.control.SeparatorMenuItem;

public class MiniCourse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7061801235084097135L;
	private String courseNumber;
	private CourseType courseType;
	private CourseGrade courseGrade;
	
	
	public MiniCourse(String courseNumber, CourseType courseType, CourseGrade courseGrade) {
		super();
		this.courseNumber = courseNumber;
		this.courseType = courseType;
		this.courseGrade = courseGrade;
	}


	public String getMiniCourseNumber() {
		return courseNumber;
	}
	


	public CourseType getCourseType() {
		return courseType;
	}


	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}


	public CourseGrade getCourseGrade() {
		return courseGrade;
	}


	public void setCourseGrade(CourseGrade courseGrade) {
		this.courseGrade = courseGrade;
	}


	@Override
	public String toString() {
		return String.format("%s%25s%15s%n", courseNumber,courseType,courseGrade);
	}
	
	public String toStringExport() {
		return String.format("::%s::%s::%s",courseNumber,courseType,courseGrade);
	}
	
	
}
