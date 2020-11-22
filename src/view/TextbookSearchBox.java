package view;

import java.text.DecimalFormat;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Faculty;
import model.PersonBag;
import model.Textbook;
import model.TextbookBag;

public class TextbookSearchBox {

	private VBox textbookSearchBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	private TextField isbnField;


	
	
	private Button searchButton;

	
	private TextbookBag theBag;
	private Textbook textbook;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	
	public TextbookSearchBox(TextbookBag theBag) {
		this.theBag=theBag;
		textbookSearchBox= new VBox(30);
		textbookSearchBox.setAlignment(Pos.CENTER);
		isbnField= new TextField();
		isbnField.setPromptText("ISBN");
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(isbnField);
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		searchButton= new Button("SEARCH");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(searchButton);
		textbookSearchBox.getChildren().addAll(box1,box2,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		searchButton.setOnAction(e->{
			String isbn= isbnField.getText();
			textbook= theBag.searchByIsbn(isbn);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Textbook Information");
			alert2.setHeaderText("Information");
			alert2.setContentText("Title: "+textbook.getTitle()+" Authors: "+textbook.getAuthors()+
					"\nPrice: "+numberFormat.format(textbook.getPrice())+" Publisher: "+ textbook.getPublisher().getPublisher());
			alert2.showAndWait();
		});
	}
	
	
	public VBox getTextbookUpdateBox() {
		return textbookSearchBox;
	}

	/*private void clearFields() {
		courseNumberField.clear();
		titleField.clear();
		numberOfCreditsField.clear();
		textbookAssignedField.clear();
	}*/
}
