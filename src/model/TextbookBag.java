package model;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TextbookBag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8417524960367353798L;
	private Textbook[] arr;
	private int nElems;
	
	
	public TextbookBag(int maxSize) {
		arr= new Textbook[maxSize];
		nElems=0;
	}
	
	public Textbook[] getArr() {
		return arr;
	}

	public void setArr(Textbook[] arr) {
		this.arr = arr;
	}
	
	public String emitRandomIsbn() {
		Textbook[] arr=getArr();
		int randomNum=(int)(Math.random()*getNElems());
		String isbn=arr[randomNum].getIsbn();
		return isbn;
	}

	public int getNElems() {
		return nElems;
	}

	public Textbook removeByIsbn(String isbn) {
		int i;
		for (i=0;i<nElems;i++) {
			if(arr[i].getIsbn().contentEquals(isbn)) {
				break;
			}
		}
		if (i==nElems) {
			Alert alert1= new Alert(AlertType.ERROR);
			alert1.setTitle("Incorrect Isbn");
			alert1.setHeaderText("Your request was not able to go through");
			alert1.setContentText("The isbn does not exist or was already deleted");
			alert1.showAndWait();
			return null;
		}
		else {
			Textbook temp= arr[i];
			for (int j=i;j<nElems-1;j++) {
				arr[j]=arr[j+1];
			}
			nElems--;
			return temp;
		}
		
	}
	
	public void updateTitle(String isbn, String title) {
		Textbook textbook= searchByIsbn(isbn);
		if (textbook== null) {
			System.out.println("No textbook found");
			return;
		}
		else {
			 textbook.setTitle(title);
			 textbook.setTitle(title);
		}
	}
	
	public Textbook updateTextbook(String title, String isbn, double price, ArrayList<Name> authors) {
		Textbook textbook= searchByIsbn(isbn);
		if (textbook== null) {
			System.out.println("No textbook found");
			return null;
		}
		else {
			textbook.setTitle(title);
			textbook.setPrice(price);
			textbook.setAuthors(authors);
			return textbook;
		}
	}
	
	public Textbook searchByIsbn(String isbn) {
		int i;
		for (i=0;i<nElems;i++) {
			if(arr[i].getIsbn().contentEquals(isbn)) {
				return arr[i];
			}
		}
		Alert alert1= new Alert(AlertType.ERROR);
		alert1.setTitle("Incorrect Isbn");
		alert1.setHeaderText("Your request was not able to go through");
		alert1.setContentText("The Isbn you entered does not exist");
		alert1.showAndWait();
		return null;
	}
	
	public void insert(Textbook aBook) {
		arr[nElems++]= aBook;
	}
	
	public void display() {
		for (int i=0; i<nElems;i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
	
	public void setNElems(int nElems) {
		this.nElems=nElems;
	}
	
}
