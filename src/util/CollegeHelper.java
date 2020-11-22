package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CollegeHelper {
	public static Object readObject(File file) throws ClassNotFoundException { 
		Object o=null;
		try {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(file));
			o=ois.readObject();
			ois.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return o;
	}
}
