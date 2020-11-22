package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import model.Course;
import model.MasterCourseBag;
import model.Name;
import model.Person;
import model.PersonBag;
import model.Student;
import model.Textbook;
import model.TextbookBag;


public class CourseHelper implements Serializable{
	public static void importData(MasterCourseBag courseBag,String courseInventoryFile) {
		File fileforInventory= new File(courseInventoryFile);
		//File fileforIsbn = new File(isbnFile);
		Scanner inventoryScanner;
		try {
			inventoryScanner = new Scanner(new BufferedReader(new FileReader(fileforInventory)));
		} catch (FileNotFoundException e1) {
			inventoryScanner=null;
			ExceptionAlerts.fileNotFound();
		}
		//Scanner isbnScanner= new Scanner(fileforIsbn);
		TextbookBag textbookBag = null;
		textbookBag = TextbookHelper.load();
		int i=0;
		while(inventoryScanner.hasNextLine()) {
			String courseNumber=inventoryScanner.nextLine();
			String courseTitle=inventoryScanner.nextLine();
			String courseDescription=inventoryScanner.nextLine();
			String courseCredits=inventoryScanner.nextLine();
			String filler=inventoryScanner.nextLine();
			String textBookAssigned=textbookBag.emitRandomIsbn();
			if (Double.parseDouble(courseCredits)>=1.0) {
			Course course= new Course(courseTitle, courseNumber,courseDescription,textBookAssigned,courseCredits);
			courseBag.insert(course);	
				}			
			}

		}
	
	public static void save(MasterCourseBag theBag) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("data/MasterCourseBag.dat",false);
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
	
	public static void saveMenu(MasterCourseBag theBag,String fileLocation) {
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
		System.out.println("Done Saving");
	}
	
	public static  MasterCourseBag load() {
		FileInputStream fos;
		try {
			fos = new FileInputStream("data/MasterCourseBag.dat");
		} catch (FileNotFoundException e) {
			fos=null;
			ExceptionAlerts.fileNotFound();
		}
		ObjectInputStream oos;
		try {
			oos = new ObjectInputStream(fos);
		} catch (IOException e) {
			oos=null;
			ExceptionAlerts.iOException();
		}
		MasterCourseBag theBag;
		try {
			theBag = (MasterCourseBag)oos.readObject();
		} catch (ClassNotFoundException e) {
			theBag=null;
			ExceptionAlerts.classNotFound();
		} catch (IOException e) {
			theBag=null;
			ExceptionAlerts.iOException();
		}
		try {
			oos.close();
		} catch (IOException e) {
			ExceptionAlerts.iOException();
		}
		System.out.println("Done Loading");
		return theBag;
	}
	
	public static  MasterCourseBag loadMenu(File file) {
		FileInputStream fos;
		try {
			fos = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			fos=null;
			ExceptionAlerts.fileNotFound();
		}
		ObjectInputStream oos;
		try {
			oos = new ObjectInputStream(fos);
		} catch (IOException e) {
			oos=null;
			ExceptionAlerts.iOException();
		}
		MasterCourseBag theBag;
		try {
			theBag = (MasterCourseBag)oos.readObject();
		} catch (ClassNotFoundException e) {
		theBag=null;
		ExceptionAlerts.classNotFound();
		} catch (IOException e) {
			theBag=null;
			ExceptionAlerts.iOException();
		}
		try {
			oos.close();
		} catch (IOException e) {
			ExceptionAlerts.iOException();
		}
		System.out.println("Done Loading");
		return theBag;
	}
	
	public static void exportCourses(MasterCourseBag theBag, String fileLocation) {
		FileWriter fw;
		try {
			fw = new FileWriter(fileLocation);
		} catch (IOException e) {
			fw=null;
			ExceptionAlerts.iOException();
		}
		PrintWriter pw = new PrintWriter(fw);
		Course[] arr = theBag.getCourseArray();
		for (int i = 0; i < theBag.getNElems(); i++) {	
				Course course = (Course) arr[i];
				pw.println(course.getCourseNumber() + "::" + course.getCourseTitle() + "::"
						+ course.getNumberOfCredits() + "::" + course.getTextbookAssigned() + "::" + course.getCourseDescritpion()
						);
			
		}
		pw.close();
	}
	
	public static void importCourses(MasterCourseBag theBag, File importFile) {
		File f =importFile;
		Scanner in;
		try {
			in = new Scanner(new BufferedReader( new FileReader(f)));
		} catch (FileNotFoundException e) {
			in=null;
			ExceptionAlerts.fileNotFound();
		}
		String courseNumber ;
		String credits;
		String isbn;
		String courseTitle;
		String courseDescription;
		in.useDelimiter("::");
		while (in.hasNextLine()) {
			String currentLine = in.nextLine();
			String[] tokens = currentLine.split("::");
			courseNumber= tokens[0];
			courseTitle = tokens[1];
			credits = tokens[2];
			isbn=tokens[3];
			courseDescription=tokens[4];
			Course course = new Course(courseTitle, courseNumber, courseDescription, isbn,credits);
			theBag.insert(course);
		}

	}
}
