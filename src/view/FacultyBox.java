package view;

import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Faculty;
import model.Major;
import model.Name;
import model.PersonBag;
import model.Student;
import model.Title;

public class FacultyBox {
	private VBox facultyBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField phoneNumberField;
	private TextField idField;
	private ComboBox<Title> titleBox;

	
	private Button insertButton;
	private Button searchButton;
	private Button removeButton;
	private Button updateButton;
	private Button saveButton;
	
	private PersonBag theBag;
	private Faculty faculty;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	
	public FacultyBox(PersonBag theBag) {
		this.theBag=theBag;
		facultyBox= new VBox(30);
		facultyBox.setAlignment(Pos.CENTER);
		idField= new TextField();
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(idField);
		firstNameField= new TextField();
		lastNameField= new TextField();
		phoneNumberField= new TextField();
		titleBox= new ComboBox<>();
		ObservableList<Title> list = FXCollections.observableArrayList(Title.INSTRUCTOR,Title.ASSOCIATE_PROFESSOR,Title.ASSISTANT_PROFESSOR,Title.PROFESSOR);
		titleBox.setItems(list);
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(firstNameField,lastNameField,phoneNumberField,titleBox);
		insertButton= new Button("INSERT");
		searchButton= new Button("SEARCH");
		removeButton= new Button("REMOVE");
		updateButton= new Button("UPDATE");
		saveButton= new Button("SAVE");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertButton,searchButton,removeButton,updateButton,saveButton);
		facultyBox.getChildren().addAll(box1,box2,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		insertButton.setOnAction(e->{
			String firstName=firstNameField.getText();
			String lastName= lastNameField.getText();
			Title title= titleBox.getValue();
			String phoneNumber=phoneNumberField.getText();
			
			Name name= new Name(firstName,lastName);
			Faculty faculty= new Faculty(name,title,phoneNumber);
			theBag.insert(faculty);
			System.out.println();
		});
		
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
		});
		
		/*saveButton.setOnAction(e->{
			try {
				CourseHelper.save(App.getCollege().getMasterCourseBag());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("IO exception");
			}
		});*/
	}
	
	public VBox getFacultyBox() {
		return facultyBox;
	}

	/*private void clearFields() {
		courseNumberField.clear();
		titleField.clear();
		numberOfCreditsField.clear();
		textbookAssignedField.clear();
	}*/
}
