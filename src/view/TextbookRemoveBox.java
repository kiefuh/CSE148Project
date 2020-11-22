package view;

import java.io.IOException;
import java.text.DecimalFormat;

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
import util.TextbookHelper;

public class TextbookRemoveBox {
	private VBox textbookRemoveBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	
	private TextField isbnField;

	
	
	private Button removeButton;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	private TextbookBag theBag;
	private Textbook textbook;
	
	public TextbookRemoveBox(TextbookBag theBag) {
		this.theBag=theBag;
		textbookRemoveBox= new VBox(30);
		textbookRemoveBox.setAlignment(Pos.CENTER);
		isbnField= new TextField();
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(isbnField);
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		removeButton= new Button("REMOVE");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(removeButton);
		textbookRemoveBox.getChildren().addAll(box1,box2,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		removeButton.setOnAction(e->{
			String isbn=isbnField.getText();
			Textbook book= theBag.removeByIsbn(isbn);
			String author="";
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Textbook Removed");
			alert2.setHeaderText("This texbook has been removed");
			alert2.setContentText("Title: "+book.getTitle()+" Authors: "+book.getAuthors()+
					"\nPrice: "+numberFormat.format(book.getPrice()));
			alert2.showAndWait();
			clearFields();
		});
	}
	
	public VBox getTextbookRemoveBox() {
		return textbookRemoveBox;
	}

	private void clearFields() {
		isbnField.clear();
	}
}
