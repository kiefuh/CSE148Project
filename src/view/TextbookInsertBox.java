package view;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import app.App;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Textbook;
import model.TextbookBag;
import util.ExceptionAlerts;
import util.TextbookHelper;
import model.Name;
import model.Publisher;

public class TextbookInsertBox {
	private VBox textbookInsertBox;
	private HBox box1;
	private HBox box2;
	private HBox box3;
	private HBox buttonBox;
	
	private TextField titleField;
	private TextField isbnField;
	private TextField priceField;
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField publisherField;
	
	private Button insertButton;
	private Button authorAddButton;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	ArrayList<Name>authors= new ArrayList<>();
	private TextbookBag theBag;
	private Textbook textbook;
	
	public TextbookInsertBox(TextbookBag theBag) {
		this.theBag=theBag;
		textbookInsertBox= new VBox(30);
		textbookInsertBox.setAlignment(Pos.CENTER);
		isbnField= new TextField();
		isbnField.setPromptText("Isbn");
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(isbnField);
		titleField= new TextField();
		titleField.setPromptText("Title");
		priceField= new TextField();
		priceField.setPromptText("Price");
		firstNameField= new TextField();
		firstNameField.setPromptText("Author first name");
		lastNameField= new TextField();
		lastNameField.setPromptText("Author last name");
		publisherField= new TextField();
		publisherField.setPromptText("Publisher");
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(titleField,priceField,firstNameField,lastNameField);
		box3= new HBox(30);
		box3.getChildren().addAll(publisherField);
		box3.setAlignment(Pos.CENTER);
		insertButton= new Button("Insert");
		authorAddButton= new Button("Add Author");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertButton,authorAddButton);
		textbookInsertBox.getChildren().addAll(box1,box2,box3,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		insertButton.setOnAction(e->{
			String isbn=isbnField.getText();
			if (isbn.length()!=17) {
				ExceptionAlerts.incorrectISBN();
			}
			else {
			String title=titleField.getText();
			double price=Double.parseDouble(numberFormat.format(Double.parseDouble(priceField.getText())));
			Name[] names= new Name[100];
			ArrayList<Name>author= new ArrayList<>();
			for(int i=0;i<authors.size();i++) {
				names[i]=authors.get(i);
				author.add(names[i]);
			}
			Publisher publisher= new Publisher(publisherField.getText());
			Textbook book= new Textbook(title, price,isbn,publisher,author);
			theBag.insert(book);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Textbook Added");
			alert2.setHeaderText("This texbook has been added");
			alert2.setContentText("Title: "+book.getTitle()+" Authors: "+author+
					"\nPrice: "+numberFormat.format(book.getPrice())+" Publisher: "+book.getPublisher().getPublisher());
			alert2.showAndWait();
			clearFields();
			}
		});
		
		authorAddButton.setOnAction(e->{
			String firstName=firstNameField.getText();
			String lastName=lastNameField.getText();
			Name name= new Name(firstName,lastName);
			authors.add(name);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Author Added");
			alert2.setHeaderText("This Author has been added");
			alert2.setContentText("You have added the following author: "+name.getFirstName()+" "+name.getLastName());
			alert2.showAndWait();
			firstNameField.clear();
			lastNameField.clear();
		});
		
	}
	
	public VBox getTextbookInsertBox() {
		return textbookInsertBox;
	}

	private void clearFields() {
		isbnField.clear();
		titleField.clear();
		priceField.clear();
		firstNameField.clear();
		lastNameField.clear();
		publisherField.clear();
	}
}
