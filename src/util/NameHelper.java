package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import model.Name;
import model.TextbookBag;

public class NameHelper {
	public static void importNames(NameBag nameBag, String firstNameFile,String lastNameFile) throws FileNotFoundException {
		File fileforFirstNameFile= new File(firstNameFile);
		File fileforLastNameFile = new File(lastNameFile);
		Scanner firstNameScanner= new Scanner(fileforFirstNameFile);
		Scanner lastNameScanner= new Scanner(fileforLastNameFile);
		
		while(firstNameScanner.hasNextLine()) {
			String firstName = firstNameScanner.nextLine();
			String lastName= lastNameScanner.nextLine();
			Name name= new Name(firstName,lastName);
			nameBag.insert(name);
		}
	}
	
	public static void save(NameBag theBag) throws IOException {
		FileOutputStream fos = new FileOutputStream("data/nameBag.dat");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(theBag);
		oos.close();
		System.out.println("Done Saving");
	}
	
	public static  NameBag load() throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("data/nameBag.dat");
		ObjectInputStream ois= new ObjectInputStream(fis);
		NameBag theBag=(NameBag)ois.readObject();
		ois.close();
		System.out.println("Done Loading");
		return theBag;
	}
}
