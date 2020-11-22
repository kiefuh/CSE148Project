package util;
import java.io.Serializable;
import java.util.Arrays;

import model.Name;
public class NameBag implements Serializable {
	private Name[] names;
	private int nElems;
	
	public NameBag(int maxSize) {
		names= new Name[maxSize];
		nElems=0;
	}
	
	public void insert(Name name) {
		names[nElems++]=name;
	}
	
	public Name[] getNames() {
		return names;
	}
	
	public int getNElems() {
		return nElems;
	}

	@Override
	public String toString() {
		return "NameBag [names=" + Arrays.toString(names) + ", nElems=" + nElems + "]";
	}
	
}
