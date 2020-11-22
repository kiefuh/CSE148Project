package model;

import java.io.Serializable;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MasterCourseBag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8715946475653345631L;
	private  Course[] courseArray;
	private  int nElems;
	
	public MasterCourseBag(int maxSize) {
		courseArray= new Course[maxSize];
		nElems=0;
	}
	
	public  Course[] getCourseArray() {
		return courseArray;
	}
	
	public int getNElems(){
		return nElems;
	}
	
	public Course removeByCourseNumber(String courseNumber) {
		int i=0;
		for (i=0;i<nElems;i++) {
			if (courseArray[i].getCourseNumber().contentEquals(courseNumber)) {
				break;
			}
		}
		
		if (i==nElems) {
			Alert alert1= new Alert(AlertType.ERROR);
			alert1.setTitle("Incorrect Course Number Alert");
			alert1.setHeaderText("Your request was not able to go through");
			alert1.setContentText("The course number you entered is not a course here or was already deleted");
			alert1.showAndWait();
			return null;
		}
		else {
			Course temp= courseArray[i];
			for (int j=i;j<nElems-1;j++) {
				courseArray[j]=courseArray[j+1];
			}
			nElems--;
			return temp;
		}
	}
	public  Course findByCourseNumber(String courseNumber) {
		int i;
		for (i=0;i<nElems;i++) {
			if(courseArray[i].getCourseNumber().equals(courseNumber)) {
				return courseArray[i];
			}
		}
		Alert alert1= new Alert(AlertType.ERROR);
		alert1.setTitle("Incorrect Course Number Alert");
		alert1.setHeaderText("Your request was not able to go through");
		alert1.setContentText("The course number you entered is not a course here");
		alert1.showAndWait();
		System.out.println("This isnt a course");
		return null;
	}
	
	public Course updateCourse(String courseNumber, String courseTitle, String textbookAssigned, double numberOfCredits,String courseDescription) {
		Course course = (Course) findByCourseNumber(courseNumber);
		if (course== null) {
			System.out.println("No course found");
			return null;
		}
		else {
			course.setCourseTitle(courseTitle);
			course.setCourseDescritpion(courseDescription);
			course.setNumberOfCredits(numberOfCredits);
			course.setTextbookAssigned(textbookAssigned);
			return course;
		}
	}
	
	public void insert(Course course) {
		courseArray[nElems++]=course;
	}
	
	public void display() {
		for (int i=0; i < nElems;i++) {
			System.out.println(courseArray[i]);
		}
		System.out.println();
	}
}
