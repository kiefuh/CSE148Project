package model;

import java.io.Serializable;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PersonBag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3098176513607554412L;
	private Person[] personArray;
	private int nElems;

	public PersonBag(int maxSize) {
		personArray=new Person[maxSize];
		nElems=0;
	}

	public Person removeByIDNumberFaculty(String id) {
		int i=0;
		for (i=0;i<nElems;i++) {
			if (personArray[i].getIDNumber().contentEquals(id)) {
				break;
			}
		}

		if (i==nElems) {
			Alert alert1= new Alert(AlertType.ERROR);
			alert1.setTitle("Incorrect ID Alert");
			alert1.setHeaderText("Your request was not able to go through");
			alert1.setContentText("The ID number you entered does not belong to a faculty member");
			alert1.showAndWait();
			return null;
		}
		else if (personArray[i] instanceof Student) {
			Alert alert1= new Alert(AlertType.ERROR);
			alert1.setTitle("Incorrect ID Alert");
			alert1.setHeaderText("Your request was not able to go through");
			alert1.setContentText("The ID number you entered does not belong to a faculty member");
			alert1.showAndWait();
			return null;
		}
		else {
			Person temp= personArray[i];
			for (int j=i;j<nElems-1;j++) {
				personArray[j]=personArray[j+1];
			}
			nElems--;
			return temp;
		}
	}
	
	public Person removeByIDNumberStudent(String id) {
		int i=0;
		for (i=0;i<nElems;i++) {
			if (personArray[i].getIDNumber().contentEquals(id)) {
				break;
			}
		}

		if (i==nElems) {
			Alert alert1= new Alert(AlertType.ERROR);
			alert1.setTitle("Incorrect ID Alert");
			alert1.setHeaderText("Your request was not able to go through");
			alert1.setContentText("The ID number you entered does not belong to a student");
			alert1.showAndWait();
			return null;
		}
		else if (personArray[i] instanceof Faculty) {
			Alert alert1= new Alert(AlertType.ERROR);
			alert1.setTitle("Incorrect ID Alert");
			alert1.setHeaderText("Your request was not able to go through");
			alert1.setContentText("The ID number you entered does not belong to a student");
			alert1.showAndWait();
			return null;
		}
		else {
			Person temp= personArray[i];
			for (int j=i;j<nElems-1;j++) {
				personArray[j]=personArray[j+1];
			}
			nElems--;
			return temp;
		}
	}

	public Person removeByIDNumber(String id) {
		int i=0;
		for (i=0;i<nElems;i++) {
			if (personArray[i].getIDNumber().contentEquals(id)) {
				break;
			}
		}

		if (i==nElems) {
			return null;
		}
		else {
			Person temp= personArray[i];
			for (int j=i;j<nElems-1;j++) {
				personArray[j]=personArray[j+1];
			}
			nElems--;
			return temp;
		}
	}
	public Person findByIdNumberStudent(String iD) {
		int i;
		for (i=0;i<nElems;i++) {
			if(personArray[i] instanceof Student) {
				if(personArray[i].getIDNumber().contentEquals(iD)) {
					return personArray[i];
				}
			}
		}
		Alert alert1= new Alert(AlertType.ERROR);
		alert1.setTitle("Incorrect ID Alert");
		alert1.setHeaderText("Your request was not able to go through");
		alert1.setContentText("The ID number you entered does not belong to a student");
		alert1.showAndWait();
		return null;
	}

	public Person findByIdNumberFaculty(String iD) {
		int i;
		for (i=0;i<nElems;i++) {
			if (personArray[i] instanceof Faculty) {
				if(personArray[i].getIDNumber().contentEquals(iD)) {
					return personArray[i];
				}
			}
		}
		Alert alert1= new Alert(AlertType.ERROR);
		alert1.setTitle("Incorrect ID Alert");
		alert1.setHeaderText("Your request was not able to go through");
		alert1.setContentText("The ID number you entered does not belong to a faculty member");
		alert1.showAndWait();
		return null;
	}

	public Faculty updateFaculty(String id, String firstName, String lastName, Title title,String phoneNumber,double salary) {
		Faculty faculty= (Faculty) findByIdNumberFaculty(id);
		if (faculty== null) {
			System.out.println("No textbook found");
			return null;
		}
		else {
			Name name= new Name(firstName,lastName);
			faculty.setTitle(title);
			faculty.setName(name);
			faculty.setPhoneNumber(phoneNumber);
			faculty.setSalary(salary);
			return faculty;
		}
	}
	
	public Student updateStudent(String id, Name name,Major major,String phoneNumber,MiniCourseBag miniCourseBag) {
		Student student= (Student) findByIdNumberStudent(id);
		if (student== null) {
			System.out.println("No textbook found");
			return null;
		}
		else {
			student.setName(name);
			student.setMajor(major);
			student.setPhoneNumber(phoneNumber);
			student.setMiniCourseBag(miniCourseBag);
			return student;
		}
	}

	public void insert(Person p) {
		personArray[nElems++]=p;
	}

	public void display() {
		for (int i=0; i < nElems;i++) {
			System.out.println(personArray[i]);
		}
		System.out.println();
	}

	public int getNElems() {

		return nElems;
	}

	public Person[] getPersonArray() {
		return personArray;
	}

	public void setPersonArray(Person[] personArray) {
		this.personArray = personArray;
	}


}
