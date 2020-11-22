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
import util.ExceptionAlerts;

public class FacultyInsertBox {
	private VBox facultyInsertBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField phoneNumberField;
	private TextField salaryField;
	private ComboBox<Title> titleBox;

	
	private Button insertButton;
	
	private PersonBag theBag;
	private Faculty faculty;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	
	public FacultyInsertBox(PersonBag theBag) {
		this.theBag=theBag;
		facultyInsertBox= new VBox(30);
		facultyInsertBox.setAlignment(Pos.CENTER);
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		firstNameField= new TextField();
		firstNameField.setPromptText("First Name");
		lastNameField= new TextField();
		lastNameField.setPromptText("Last Name");
		phoneNumberField= new TextField();
		phoneNumberField.setPromptText("Phone Number");
		salaryField= new TextField();
		salaryField.setPromptText("Salary");
		titleBox= new ComboBox<>();
		ObservableList<Title> list = FXCollections.observableArrayList(Title.INSTRUCTOR,Title.ASSOCIATE_PROFESSOR,Title.ASSISTANT_PROFESSOR,Title.PROFESSOR);
		titleBox.setItems(list);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().addAll(firstNameField,lastNameField);
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(salaryField,phoneNumberField,titleBox);
		insertButton= new Button("INSERT");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertButton);
		facultyInsertBox.getChildren().addAll(box1,box2,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		insertButton.setOnAction(e->{
			String firstName=firstNameField.getText();
			String lastName= lastNameField.getText();
			Title title= titleBox.getValue();
			String phoneNumber=phoneNumberField.getText();;
			if(phoneNumber.length()!=10) {
					ExceptionAlerts.incorrectPhoneNumber();
				}
			else {
			double salary=Double.parseDouble(salaryField.getText());
			Name name= new Name(firstName,lastName);
			Faculty faculty= new Faculty(name,title,phoneNumber,salary);
			theBag.insert(faculty);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Success");
			alert2.setHeaderText("You have successfully added this faculty member");
			alert2.setContentText("First Name: "+faculty.getName().getFirstName()+" Last Name: "+faculty.getName().getLastName()+
					"\nPhone Number: "+faculty.getPhoneNumber()+" Title: "+ faculty.getTitle()+
					"\nSalary: "+numberFormat.format(faculty.getSalary())+" ID Number: "+faculty.getId());
			alert2.showAndWait();
			}
		});
		
	}
	
	public VBox getFacultyInsertBox() {
		return facultyInsertBox;
	}

	/*private void clearFields() {
		courseNumberField.clear();
		titleField.clear();
		numberOfCreditsField.clear();
		textbookAssignedField.clear();
	}*/
}

