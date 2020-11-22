package view;

import java.io.IOException;

import app.App;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Textbook;
import model.TextbookBag;
import util.TextbookHelper;

public class TextbookBox {
	private VBox textbookBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	private TextField titleField;
	private TextField isbnField;
	private TextField priceField;
	
	private Button insertButton;
	private Button searchButton;
	private Button removeButton;
	private Button updateButton;
	private Button saveButton;
	
	private TextbookBag theBag;
	private Textbook textbook;
	
	public TextbookBox(TextbookBag theBag) {
		this.theBag=theBag;
		textbookBox= new VBox(30);
		textbookBox.setAlignment(Pos.CENTER);
		isbnField= new TextField();
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(isbnField);
		titleField= new TextField();
		priceField= new TextField();
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(titleField,priceField);
		insertButton= new Button("INSERT");
		searchButton= new Button("SEARCH");
		removeButton= new Button("REMOVE");
		updateButton= new Button("UPDATE");
		saveButton= new Button("SAVE");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertButton,searchButton,removeButton,updateButton,saveButton);
		textbookBox.getChildren().addAll(box1,box2,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		insertButton.setOnAction(e->{
			String isbn=isbnField.getText();
			String title=titleField.getText();
			double price=Double.parseDouble(priceField.getText());
			Textbook book= new Textbook(title, price,isbn);
			theBag.insert(book);
		});
		
		searchButton.setOnAction(e->{
			String isbn= isbnField.getText();
			textbook= theBag.searchByIsbn(isbn);
			titleField.setText(textbook.getTitle());
			priceField.setText(String.valueOf(textbook.getPrice()));
		});
		
		
		saveButton.setOnAction(e->{
			
				TextbookHelper.save(App.getCollege().getTextbookBag());
		});
	}
	
	public VBox getTextbookBox() {
		return textbookBox;
	}

	private void clearFields() {
		isbnField.clear();
		titleField.clear();
		priceField.clear();
	}
	
	
}
