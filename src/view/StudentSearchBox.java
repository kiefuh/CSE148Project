package view;


import java.awt.Cursor;
import java.text.DecimalFormat;

import app.App;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.MajorTemplate;
import model.PersonBag;
import model.Student;

public class StudentSearchBox {
	private VBox studentSearchBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	private TextField idField;
	
	private Button searchButton;
	
	private PersonBag theBag;
	private Student student;
	private MajorTemplate template;
	private String courses="Courses";
	private String status="Status";
	private String grade="Grade";
	
	private DecimalFormat numberFormat= new DecimalFormat("#.00");

	
	public StudentSearchBox(PersonBag theBag) {
		this.theBag=theBag;
		studentSearchBox= new VBox(30);
		studentSearchBox.setAlignment(Pos.CENTER);
		idField= new TextField();
		idField.setPromptText("ID");
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().addAll(idField);
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		searchButton= new Button("SEARCH");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(searchButton);
		studentSearchBox.getChildren().addAll(box1,box2,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		searchButton.setOnAction(e->{
			String id= idField.getText();
			Alert alert2= new Alert(AlertType.INFORMATION);
			ObservableList<Node> blah = alert2.getDialogPane().getChildren();
			for(Node n: blah) {
				if(n instanceof Label)
					((Label)n).setFont(new Font("Courier", 12));
			}
			student= (Student)theBag.findByIdNumberStudent(id);
			alert2.setTitle("Student ");
			alert2.setHeaderText("Information");
			alert2.setContentText("First Name: "+student.getName().getFirstName()+" Last Name: "+student.getName().getLastName()+
					"\nPhone Number: "+student.getPhoneNumber()+" Major: "+student.getMajor()+" GPA: "+numberFormat.format(student.getGpa(App.getCollege()))
					+"\n\n			Classes\n\n"+String.format("%s%25s%20s%n", courses,status,grade)+student.getMiniCourseBag().toString());
			alert2.showAndWait();
			clearFields();
		});
		
	}
	
	public VBox getStudentSearchBox() {
		return studentSearchBox;
	}

	private void clearFields() {
		idField.clear();
		
	}
}
