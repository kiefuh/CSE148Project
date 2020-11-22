package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import app.App;
import model.CourseGrade;
import model.CourseType;
import model.Faculty;
import model.Major;
import model.MajorTemplate;
import model.MasterCourseBag;
import model.MiniCourse;
import model.MiniCourseBag;
import model.Name;
import model.Person;
import model.PersonBag;
import model.Student;
import model.TextbookBag;
import model.Title;

public class PersonHelper {
	public static void exportFaculty(PersonBag theBag, String fileLocation)  {
		FileWriter fw;
		try {
			fw = new FileWriter(fileLocation);
		} catch (IOException e) {
			fw=null;
			ExceptionAlerts.iOException();
		}
		PrintWriter pw = new PrintWriter(fw);
		Person[] arr = theBag.getPersonArray();
		for (int i = 0; i < theBag.getNElems(); i++) {
			if (arr[i] instanceof Faculty) {
				Faculty faculty = (Faculty) arr[i];
				pw.println(faculty.getName().getFirstName() + "::" + faculty.getName().getLastName() + "::"
						+ faculty.getPhoneNumber() + "::" + faculty.getTitle() + "::" + faculty.getSalary() + "::");
			}
		}
		pw.close();
	}

	public static void importFaculty(PersonBag theBag, File importFile) {
		File f = importFile;
		Scanner in;
		try {
			in = new Scanner(f);
		} catch (FileNotFoundException e) {
			in=null;
			ExceptionAlerts.fileNotFound();
		}
		Title title = null;
		double salary;
		in.useDelimiter("::");
		while (in.hasNextLine()) {
			String currentLine = in.nextLine();
			String[] tokens = currentLine.split("::");
			String firstName = tokens[0];
			String lastName = tokens[1];
			String phoneNumber = tokens[2];
			String titleTemp1 = tokens[3];
			if (titleTemp1.contentEquals("PROFESSOR")) {
				title = Title.PROFESSOR;
			} else if (titleTemp1.contentEquals("ASSOCIATE_PROFESSOR")) {
				title = Title.ASSOCIATE_PROFESSOR;
			} else if (titleTemp1.contentEquals("ASSISTANT_PROFESSOR")) {
				title = Title.ASSISTANT_PROFESSOR;
			} else if (titleTemp1.contentEquals("INSTRUCTOR")) {
				title = Title.INSTRUCTOR;
			}
			salary = Double.parseDouble(tokens[4]);
			Name name = new Name(firstName, lastName);
			Faculty faculty = new Faculty(name, title, phoneNumber, salary);
			theBag.insert(faculty);
		}

	}

	public static void exportStudent(PersonBag theBag,String fileLocation) {
		FileWriter fw;
		try {
			fw = new FileWriter(fileLocation);
		} catch (IOException e) {
			fw=null;
			ExceptionAlerts.iOException();
		}
		PrintWriter pw = new PrintWriter(fw);
		Person[] arr = theBag.getPersonArray();
		for (int i = 0; i < theBag.getNElems(); i++) {
			if (arr[i] instanceof Student) {
				Student student = (Student) arr[i];
				pw.println(student.getName().getFirstName() + "::" + student.getName().getLastName() + "::"
						+ student.getPhoneNumber() + "::" + student.getMajor() + "::" + student.getGpaExport()
						+ student.getMiniCourseBag().toStringExport()+"::");
			}
		}
		pw.close();
	}

	public static void importStudent(PersonBag theBag, File importFile) {
		File f = importFile;
		Scanner in;
		try {
			in = new Scanner(f);
		} catch (FileNotFoundException e) {
			in=null;
			ExceptionAlerts.fileNotFound();
		}
		Major major = null;
		double gpa;
		MiniCourseBag miniCourseBag;
		in.useDelimiter("::");
		while (in.hasNextLine()) {
			String currentLine = in.nextLine();
			String[] tokens = currentLine.split("::");
			String firstName = tokens[0];
			String lastName = tokens[1];
			String phoneNumber = tokens[2];
			String majorTemp1 = tokens[3];
			if (majorTemp1.contentEquals("CSE")) {
				major = Major.CSE;
			} else if (majorTemp1.contentEquals("CST")) {
				major = Major.CST;
			}
			gpa = Double.parseDouble(tokens[4]);
			Name name = new Name(firstName, lastName);
			MajorTemplate majorTemplate = new MajorTemplate();
			MiniCourseBag mBag = new MiniCourseBag(100);
			String courseNumber;
			CourseType courseStatus;
			CourseGrade courseGrade;
			for (int i = 5; i < tokens.length-1; i++) {
				courseNumber=tokens[i++];
				courseStatus=CourseType.valueOf(tokens[i++]);
				courseGrade=CourseGrade.valueOf(tokens[i]);
				MiniCourse m= new MiniCourse(courseNumber,courseStatus,courseGrade);
				mBag.insert(m);
			}
			Student student = new Student(name, major, mBag, phoneNumber);
			student.getGpa(App.getCollege());
			theBag.insert(student);
		}

	}
	
	public static void save(PersonBag theBag) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("data/personBag.dat",false);
		} catch (FileNotFoundException e) {
			fos=null;
			ExceptionAlerts.fileNotFound();
		}
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			oos=null;
			ExceptionAlerts.iOException();
		}
		try {
			oos.writeObject(theBag);
		} catch (IOException e) {
			ExceptionAlerts.iOException();
		}
		try {
			oos.close();
		} catch (IOException e) {
			ExceptionAlerts.iOException();
		}
		System.out.println("Done Saving");
	}
	
	public static void saveMenu(PersonBag theBag,String fileLocation) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileLocation,false);
		} catch (FileNotFoundException e) {
			fos=null;
			ExceptionAlerts.fileNotFound();
		}
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			oos=null;
			ExceptionAlerts.iOException();
		}
		try {
			oos.writeObject(theBag);
		} catch (IOException e) {
			ExceptionAlerts.iOException();
		}
		try {
			oos.close();
		} catch (IOException e) {
			ExceptionAlerts.iOException();
		}
		
	}
	
	public static PersonBag load(){
		FileInputStream fis;
		try {
			fis = new FileInputStream("data/personBag.dat");
		} catch (FileNotFoundException e) {
			fis=null;
			ExceptionAlerts.fileNotFound();
		}
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			ois=null;
			ExceptionAlerts.iOException();
		}
		PersonBag theBag;
		try {
			theBag = (PersonBag)ois.readObject();
		} catch (ClassNotFoundException e) {
			theBag=null;
			ExceptionAlerts.classNotFound();
		} catch (IOException e) {
			theBag=null;
			ExceptionAlerts.iOException();
		}
		try {
			ois.close();
		} catch (IOException e) {
			ExceptionAlerts.iOException();
		}
		System.out.println("Done Loading");
		return theBag;
	}
	
	public static PersonBag loadMenu(File file) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			fis=null;
			ExceptionAlerts.fileNotFound();
		}
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			ois=null;
			ExceptionAlerts.iOException();
		}
		PersonBag theBag;
		try {
			theBag = (PersonBag)ois.readObject();
		} catch (ClassNotFoundException e) {
			theBag=null;
			ExceptionAlerts.classNotFound();
		} catch (IOException e) {
			theBag=null;
			ExceptionAlerts.iOException();
		}
		try {
			ois.close();
		} catch (IOException e) {
			ExceptionAlerts.iOException();
		}
		System.out.println("Done Loading");
		return theBag;
	}

}
