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
import model.PersonBag;
import model.Title;
import util.ExceptionAlerts;

public class FacultyUpdateBox {
	private VBox facultyUpdateBox;
	private HBox box1;
	private HBox box2;
	private HBox box3;
	private HBox buttonBox;
	
	private TextField idField;
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField phoneNumberField;
	private TextField salaryField;
	private ComboBox<Title> titleBox;


	
	
	private Button updateButton;
	private Button searchButton;

	
	private PersonBag theBag;
	private Faculty faculty;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	
	public FacultyUpdateBox(PersonBag theBag) {
		this.theBag=theBag;
		facultyUpdateBox= new VBox(30);
		facultyUpdateBox.setAlignment(Pos.CENTER);
		idField= new TextField();
		idField.setPromptText("ID");
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(idField);
		box2= new HBox(30);
		box3= new HBox(30);
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
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(firstNameField,lastNameField);
		box3.setAlignment(Pos.CENTER);
		box3.getChildren().addAll(salaryField,phoneNumberField,titleBox);
		updateButton= new Button("UPDATE");
		searchButton= new Button("Search");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(searchButton,updateButton);
		facultyUpdateBox.getChildren().addAll(box1,box2,box3,buttonBox);
		
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
			firstNameField.setText(faculty.getName().getFirstName());
			lastNameField.setText(faculty.getName().getLastName());
			phoneNumberField.setText(faculty.getPhoneNumber());
			titleBox.setValue(faculty.getTitle());
			salaryField.setText(String.valueOf(numberFormat.format(faculty.getSalary())));
		});
		
		updateButton.setOnAction(e->{
			String id= idField.getText();
			String firstName=firstNameField.getText();
			String lastName= lastNameField.getText();
			Title title= titleBox.getValue();
			String phoneNumber=phoneNumberField.getText();
			if (phoneNumber.length()!=10) {
				ExceptionAlerts.incorrectPhoneNumber();
			}
			else {
			double salary=Double.parseDouble(salaryField.getText());
			faculty= (Faculty)theBag.updateFaculty(id, firstName, lastName, title, phoneNumber, salary);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Faculty Member Updated");
			alert2.setHeaderText("The faculty members new information is ");
			alert2.setContentText("First Name: "+faculty.getName().getFirstName()+" Last Name: "+faculty.getName().getLastName()+
					"\nPhone Number: "+faculty.getPhoneNumber()+" Title: "+ faculty.getTitle()+
					"\nSalary: "+numberFormat.format(faculty.getSalary()));
			alert2.showAndWait();
			}
		});
	}
	
	
	public VBox getFacultyUpdateBox() {
		return facultyUpdateBox;
	}
}
