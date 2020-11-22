package util;

import java.io.IOException;
import java.util.ArrayList;

import model.Faculty;
import model.Major;
import model.MajorTemplate;
import model.MiniCourseBag;
import model.Name;
import model.Person;
import model.PersonBag;
import model.Student;
import model.Title;

public class PersonFactory {
	private PersonBag personBag;
	public PersonFactory(PersonBag personBag) {
		this.personBag= deepCopy(personBag);
	}

	private PersonBag deepCopy(PersonBag personBag) {
		PersonBag personCopy= personBag;
		return personCopy;
	}
	
	
	
	public Person emitPerson() {
		int randomNumber=(int) (Math.random()*personBag.getNElems());
		Person[] personArray= personBag.getPersonArray();
		return personArray[randomNumber];
		/*Random rand= new Random();
		String randomFirstName=firstNames[rand.nextInt(firstNames.length)];
		String randomLastName=lastNames[rand.nextInt(lastNames.length)];
		Name randomName= new Name(randomFirstName,randomLastName);*/
		
	}
	
	public PersonBag fillPersonBagStudents(PersonBag personBag,int j) {
		NameBag nameBag=null;
		try {
			nameBag=NameHelper.load();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Did not load properly");
			 nameBag=null;
		}
		NameFactory nf= new NameFactory(nameBag);
		MiniCourseBag theBag;
		MajorTemplate template= new MajorTemplate();
		for(int i=0;i<j;i++) {
		Name name=nf.emitName();
		int majorRandNum=(int)(Major.values().length*Math.random());
		Major[] majorArr= Major.values();
		Major major=majorArr[majorRandNum];
		/*if (major==Major.CSE) {
			theBag=template.getMiniCourseBag(major);
			Student student= new Student(name,major,theBag,emitARandomPhoneNumber());
			personBag.insert(student);
		}*/
		Student student= new Student(name,Major.CSE,template.getMiniCourseBag(Major.CSE),emitARandomPhoneNumber());
		personBag.insert(student);
		}
		
		return personBag;
	}
	
	public PersonBag fillPersonBagFaculty(PersonBag personBag,int j) {
		NameBag nameBag=null;
		try {
			nameBag=NameHelper.load();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Did not load properly");
			 nameBag=null;
		}
		NameFactory nf= new NameFactory(nameBag);
		for(int i=0;i<j;i++) {
		Name name=nf.emitName();
		int titleRandNum=(int)(Title.values().length*Math.random());
		Title[] titleArr= Title.values();
		Title title=titleArr[titleRandNum];
		Faculty faculty= new Faculty(name,title,emitARandomPhoneNumber());
		personBag.insert(faculty);
		}
		
		return personBag;
	}
	
	public String emitARandomPhoneNumber() {
		String str="631";
		for (int i=0;i<=6;i++) {
			int randomNumber=48+ (int) (Math.random()*10);
			str=str+(char)randomNumber;
		}
		return str;
}
	
	
	
	/*public ArrayList<Name> emitPersonList(int n) {
		ArrayList<Name>list= new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(emitName());
		}
		return list;
		
	}*/
}
