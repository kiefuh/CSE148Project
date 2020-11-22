package model;

import java.io.Serializable;
import java.util.ArrayList;

import app.App;
import util.NameFactory;
import util.NameHelper;

public class Textbook implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7172461184707010973L;
	private String title;
	private double price;
	private String isbn;
	private ArrayList<Name> authors;
	private Publisher publisher;
	private String author;
	//NameFactory nf = new NameFactory(App.getNameBag());

	public Textbook(String title, double price, String isbn, Publisher publisher, ArrayList<Name> authors) {
		super();
		this.title = title;
		this.price = price;
		this.isbn = isbn;
		this.authors = authors;
		this.publisher = publisher;
	}

	public Textbook(String title, double price, String isbn) {
		super();
		this.title = title;
		this.price = price;
		this.isbn = isbn;
		//this.authors = nf.emitNameList(2);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public ArrayList<Name> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Name> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Textbook [title=" + title + ", price=" + price + ", isbn=" + isbn + ", authors=" + authors + "]";
	}

	public String toStringExport() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < authors.size(); i++) { // ctrl shift f
			String name = authors.get(i).toStringExport();
			sb.append(String.format("|%s|", name));
		}
		String s = sb.toString();
		System.out.println(s);
		return title + "|" + price + "|" + isbn + "|" + publisher.getPublisher() + s;
	}

}
