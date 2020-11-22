package view;

import java.text.DecimalFormat;

import app.App;
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

public class FacultyDeleteBox {
	private VBox facultyDeleteBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	private TextField idField;
	

	
	
	private Button removeButton;
	
	private PersonBag theBag;
	private Faculty faculty;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	
	public FacultyDeleteBox(PersonBag theBag) {
		this.theBag=theBag;
		facultyDeleteBox= new VBox(30);
		facultyDeleteBox.setAlignment(Pos.CENTER);
		idField= new TextField();
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(idField);
		removeButton= new Button("REMOVE");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(removeButton);
		facultyDeleteBox.getChildren().addAll(box1,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		
		
		removeButton.setOnAction(e->{
			String id= idField.getText();
			Faculty faculty=(Faculty)theBag.removeByIDNumberFaculty(id);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Removal Complete");
			alert2.setHeaderText("This is the information of the faculty member you removed");
			alert2.setContentText("First Name: "+faculty.getName().getFirstName()+" Last Name: "+faculty.getName().getLastName()+
					"\nPhone Number: "+faculty.getPhoneNumber()+" Title: "+ faculty.getTitle()+
					"\nSalary: "+numberFormat.format(faculty.getSalary()));
			alert2.showAndWait();
		});
	}
		
	
	public VBox getFacultyDeleteBox() {
		return facultyDeleteBox;
	}

	/*private void clearFields() {
		courseNumberField.clear();
		titleField.clear();
		numberOfCreditsField.clear();
		textbookAssignedField.clear();
	}*/
}
