package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import model.Name;
public class NameFactory implements Serializable{
	/*private String[] firstNames;
	private String[] lastNames;
	
	public NameFactory(String[] firstNames, String[] lastNames) {
		this.firstNames=deepCopy(firstNames);
		this.lastNames=deepCopy(lastNames);
	}*/
	private NameBag nameBag;
	public NameFactory(NameBag nameBag) {
		this.nameBag= deepCopy(nameBag);
	}

	private NameBag deepCopy(NameBag nameBag) {
		NameBag namesCopy= nameBag;
		return namesCopy;
	}
	
	public Name emitName() {
		int randomNumber=(int) (Math.random()*nameBag.getNElems());
		Name[] nameArray= nameBag.getNames();
		return nameArray[randomNumber];
		/*Random rand= new Random();
		String randomFirstName=firstNames[rand.nextInt(firstNames.length)];
		String randomLastName=lastNames[rand.nextInt(lastNames.length)];
		Name randomName= new Name(randomFirstName,randomLastName);*/
		
	}
	
	public ArrayList<Name> emitNameList(int n) {
		ArrayList<Name>list= new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(emitName());
		}
		return list;
		
	}
}
