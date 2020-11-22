package view;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Name;
import model.Textbook;
import model.TextbookBag;
import util.ExceptionAlerts;

public class TextbookUpdateBox {
	private VBox textbookUpdateBox;
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
	
	private Button updateButton;
	private Button searchButton;
	private Button authorAddButton;
	
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	ArrayList<Name>authors= new ArrayList<>();
	private TextbookBag theBag;
	private Textbook textbook;
	
	public TextbookUpdateBox(TextbookBag theBag) {
		this.theBag=theBag;
		textbookUpdateBox= new VBox(30);
		textbookUpdateBox.setAlignment(Pos.CENTER);
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
		box3.setAlignment(Pos.CENTER);
		box3.getChildren().addAll(publisherField);
		updateButton= new Button("Update");
		authorAddButton= new Button("Add Author");
		searchButton= new Button("Search");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(searchButton,updateButton,authorAddButton);
		textbookUpdateBox.getChildren().addAll(box1,box2,box3,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		searchButton.setOnAction(e->{
			String isbn= isbnField.getText();
			
			textbook= theBag.searchByIsbn(isbn);
			titleField.setText(textbook.getTitle());
			priceField.setText(String.valueOf(numberFormat.format(textbook.getPrice())));
			firstNameField.setText(textbook.getAuthors().get(0).getFirstName());
			lastNameField.setText(textbook.getAuthors().get(0).getLastName());
			publisherField.setText(textbook.getPublisher().getPublisher());
		});
		updateButton.setOnAction(e->{
			String isbn=isbnField.getText();
			if(isbn.length()!=17) {
				ExceptionAlerts.incorrectISBN();
			}
			else {
			String title=titleField.getText();
			double price=Double.parseDouble(priceField.getText());
			Name[] names= new Name[100];
			ArrayList<Name>author= new ArrayList<>();
			for(int i=0;i<authors.size();i++) {
				names[i]=authors.get(i);
				author.add(names[i]);
			}
			//ArrayList<Name>author=(ArrayList<Name>) authors.clone();
			theBag.updateTextbook(title, isbn, price, author);
			/*String author="";
			for (int i=0; i<authors.size();i++) {
				String authorTemp=authors.get(i).toString();
				author=author+authorTemp;
			}*/
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Textbook updated");
			alert2.setHeaderText("This texbook has been updated");
			alert2.setContentText("Title: "+title+" Authors: "+author+
					"\nPrice: "+numberFormat.format(price));
			alert2.showAndWait();
			authors.clear();
			clearFields();
			}
		});
		
		authorAddButton.setOnAction(e->{
			String firstName=firstNameField.getText();
			String lastName=lastNameField.getText();
			Name name= new Name(firstName,lastName);
			authors.add(name);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Textbook update");
			alert2.setHeaderText("You've added an author");
			alert2.setContentText("You have added the following author: "+name.getFirstName()+" "+name.getLastName());
			alert2.showAndWait();
			firstNameField.clear();
			lastNameField.clear();
		});
		
	}
	
	public VBox getTextbookUpdateBox() {
		return textbookUpdateBox;
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
