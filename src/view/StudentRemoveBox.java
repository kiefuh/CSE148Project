package view;

import java.text.DecimalFormat;

import app.App;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.MajorTemplate;
import model.PersonBag;
import model.Student;

public class StudentRemoveBox {
	private VBox studentRemoveBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	private TextField idField;
	
	private Button removeButton;
	
	private PersonBag theBag;
	private Student student;
	private MajorTemplate template;
	private String courses="Courses";
	private String status="Status";
	private String grade="Grade";
	
	private DecimalFormat numberFormat= new DecimalFormat("#.00");

	
	public StudentRemoveBox(PersonBag theBag) {
		this.theBag=theBag;
		studentRemoveBox= new VBox(30);
		studentRemoveBox.setAlignment(Pos.CENTER);
		idField= new TextField();
		idField.setPromptText("ID");
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(idField);
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		removeButton= new Button("Remove");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(removeButton);
		studentRemoveBox.getChildren().addAll(box1,box2,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		removeButton.setOnAction(e->{
			String id= idField.getText();
			Alert alert2= new Alert(AlertType.INFORMATION);
			ObservableList<Node> format = alert2.getDialogPane().getChildren();
			for(Node n: format) {
				if(n instanceof Label)
					((Label)n).setFont(new Font("Courier", 12));
			}
			student= (Student)theBag.removeByIDNumberStudent(id);
			alert2.setTitle("Student ");
			alert2.setHeaderText("Information");
			alert2.setContentText("First Name: "+student.getName().getFirstName()+" Last Name: "+student.getName().getLastName()+
					"\nPhone Number: "+student.getPhoneNumber()+" Major: "+student.getMajor()+" GPA: "+numberFormat.format(student.getGpa(App.getCollege())));
			alert2.showAndWait();
			clearFields();
		});
		
	}
	
	public VBox getStudentRemoveBox() {
		return studentRemoveBox;
	}

	private void clearFields() {
		idField.clear();
		
	}
}
