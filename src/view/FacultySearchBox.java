package view;

import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Faculty;
import model.Name;
import model.PersonBag;
import model.Title;

public class FacultySearchBox {
	private VBox facultySearchBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	private TextField idField;


	
	
	private Button searchButton;

	
	private PersonBag theBag;
	private Faculty faculty;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	
	public FacultySearchBox(PersonBag theBag) {
		this.theBag=theBag;
		facultySearchBox= new VBox(30);
		facultySearchBox.setAlignment(Pos.CENTER);
		idField= new TextField();
		idField.setPromptText("ID");
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(idField);
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		searchButton= new Button("SEARCH");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(searchButton);
		facultySearchBox.getChildren().addAll(box1,box2,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		searchButton.setOnAction(e->{
			String id= idField.getText();
			faculty= (Faculty)theBag.findByIdNumberFaculty(id);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Faculty Information");
			alert2.setHeaderText("Information");
			alert2.setContentText("First Name: "+faculty.getName().getFirstName()+" Last Name: "+faculty.getName().getLastName()+
					"\nPhone Number: "+faculty.getPhoneNumber()+" Title: "+ faculty.getTitle()+
					"\nSalary: "+numberFormat.format(faculty.getSalary()));
			alert2.showAndWait();
		});
	}
	
	
	public VBox getFacultyBox() {
		return facultySearchBox;
	}

	/*private void clearFields() {
		courseNumberField.clear();
		titleField.clear();
		numberOfCreditsField.clear();
		textbookAssignedField.clear();
	}*/
}
