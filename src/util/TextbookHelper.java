package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import app.App;
import model.CourseGrade;
import model.CourseType;
import model.Faculty;
import model.Major;
import model.MajorTemplate;
import model.MiniCourse;
import model.MiniCourseBag;
import model.Name;
import model.Person;
import model.PersonBag;
import model.Publisher;
import model.PublisherBag;
import model.Student;
import model.Textbook;
import model.TextbookBag;

public class TextbookHelper {
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	static int bookCount=0;
	public static void importData(TextbookBag textbookBag,String titleFile,String isbnFile,double priceFile) {
		File fileforTitle= new File(titleFile);
		File fileforIsbn = new File(isbnFile);
		Scanner titleScanner;
		try {
			titleScanner = new Scanner(fileforTitle);
		} catch (FileNotFoundException e) {
			titleScanner=null;
			ExceptionAlerts.fileNotFound();
		}
		Scanner isbnScanner;
		try {
			isbnScanner = new Scanner(fileforIsbn);
		} catch (FileNotFoundException e) {
			isbnScanner=null;
			ExceptionAlerts.fileNotFound();
		}
		
		while(isbnScanner.hasNextLine()) {
			String title=titleScanner.nextLine();
			String isbn=isbnScanner.nextLine();
			double price= Math.random()*200;
			ArrayList<Name> nameList;
			nameList = getNames();
			PublisherBag publisherBag=App.getPublisherBag();
			Textbook textbook= new Textbook(title,price,isbn,publisherBag.emitAPublisher(), nameList);
			textbookBag.insert(textbook);
			bookCount++;
		}
		System.out.println("import complete");
	}
	
	public static void importPublisherData(PublisherBag theBag,String publisherFile) {
		File fileforPublisher= new File(publisherFile);
		Scanner publisherScanner;
		try {
			publisherScanner = new Scanner(fileforPublisher);
		} catch (FileNotFoundException e) {
			publisherScanner=null;
			ExceptionAlerts.fileNotFound();
		}
		while(publisherScanner.hasNextLine()) {
			String publisherName=publisherScanner.nextLine();
			Publisher publisher= new Publisher(publisherName);
			theBag.insert(publisher);
		}
		System.out.println("import complete");
	}
	
	
	
	public static void save(TextbookBag theBag) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("data/textbookBag.dat",false);
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
	
	public static void saveMenu(TextbookBag theBag, String fileName) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName,false);
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
	
	public static  TextbookBag load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("data/textbookBag.dat");
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
		TextbookBag theBag;
		try {
			theBag = (TextbookBag)ois.readObject();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done Loading");
		return theBag;
	}
	
	public static  TextbookBag loadMenu(File file) {
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
		TextbookBag theBag;
		try {
			theBag = (TextbookBag)ois.readObject();
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
	
	public static void exportTextbook(TextbookBag theBag, String fileLocation) {
		FileWriter fw;
		try {
			fw = new FileWriter(fileLocation);
		} catch (IOException e) {
			fw=null;
			ExceptionAlerts.iOException();
		}
		PrintWriter pw= new PrintWriter(fw);
		Textbook[] arr= theBag.getArr();
		for (int i=0;i<theBag.getNElems();i++) {
			
				Textbook textbook= arr[i];
				pw.println(textbook.toStringExport());
			
		}
		pw.close();
	}
	
	public static void importTextbooks(TextbookBag theBag, File importFile) {
		File f = importFile;
		Scanner in;
		try {
			in = new Scanner(f);
		} catch (FileNotFoundException e) {
			in=null;
			ExceptionAlerts.fileNotFound();
		}
		String title ;
		double price;
		String isbn;
		in.useDelimiter("\\|");
		Name name;
		String firstName;
		String lastName;
		while (in.hasNextLine()) {
			ArrayList<Name> authorList= new ArrayList<>();
			String currentLine = in.nextLine();
			String[] tokens = currentLine.split("\\|");
			title= tokens[0];
			price = Double.parseDouble(tokens[1]);
			isbn = tokens[2];
			Publisher publisher= new Publisher(tokens[3]);
			for (int i = 4; i < tokens.length-1; i++) {
				firstName=tokens[i++];
				lastName=tokens[i];
				name=new Name(firstName,lastName);
				authorList.add(name);
			}
			Textbook textbook = new Textbook(title, price, isbn,publisher, authorList);
			theBag.insert(textbook);
		}

	}
	
	public static int getBookCount() {
		return bookCount;
	}
	public static ArrayList<Name> getNames() {
		NameBag nameBag= new NameBag(10000);
		try {
			NameHelper.importNames(nameBag, "inputData/first Names.txt", "inputData/last Names.txt");
		} catch (FileNotFoundException e) {
			ExceptionAlerts.fileNotFound();
		}
		NameFactory nameFactory= new NameFactory(nameBag);
		int randomNumber= 1+((int)Math.random()*3);
		ArrayList<Name> nameList=nameFactory.emitNameList(randomNumber);
		
		return nameList;
	}
}
