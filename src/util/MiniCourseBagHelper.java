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
import java.io.Serializable;
import java.util.Scanner;

import model.MiniCourse;
import model.MiniCourseBag;



public class MiniCourseBagHelper implements Serializable{
	public static void save(MiniCourseBag theBag) throws IOException {
		FileOutputStream fos = new FileOutputStream("data/minicoursebag.dat");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(theBag);
		oos.close();
		System.out.println("Done Saving");
	}
	
	public static  MiniCourseBag load() throws ClassNotFoundException, IOException {
		FileInputStream fos = new FileInputStream("data/minicoursebag.dat");
		ObjectInputStream oos= new ObjectInputStream(fos);
		MiniCourseBag theBag=(MiniCourseBag)oos.readObject();
		oos.close();
		System.out.println("Done Loading");
		return theBag;
	}
	
	public static void export(MiniCourseBag theBag) throws IOException {
		FileWriter fw= new FileWriter("data/minicoursebag.txt",true);
		PrintWriter pw= new PrintWriter(fw);
		MiniCourse[] arr= theBag.getMiniCourseArray();
		for (int i=0;i<theBag.getNElems();i++) {
				pw.print(arr[i].getMiniCourseNumber()+"\n"+arr[i].getCourseGrade()+"\n"+arr[i].getCourseType());
			}
		pw.close();
		}
	
	
	/*public static MiniCourseBag importData(String importFile) throws FileNotFoundException {
		File f= new File(importFile);
		Scanner file= new Scanner(f);
		MiniCourse[] miniCourseArray= new MiniCourse[50];
		int i=0;
		while (file.hasNext()) {
			
		}
		
	}*/
}
