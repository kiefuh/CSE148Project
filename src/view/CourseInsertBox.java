package view;

import java.text.DecimalFormat;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Course;
import model.MasterCourseBag;

public class CourseInsertBox {
	private VBox courseInsertBox;
	private HBox box1;
	private HBox box2;
	private HBox box3;
	private HBox buttonBox;
	
	private TextField courseNumberField;
	private TextField courseTitleField;
	private TextArea courseDescriptionField;
	private TextField courseCreditsField;
	private TextField textbookAssignedField;

	
	
	private Button searchButton;

	
	private MasterCourseBag theBag;
	private Course course;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	
	public CourseInsertBox(MasterCourseBag theBag) {
		this.theBag=theBag;
		courseInsertBox= new VBox(30);
		courseInsertBox.setAlignment(Pos.CENTER);
		courseNumberField= new TextField();
		courseNumberField.setPromptText("Course Number");
		courseTitleField= new TextField();
		courseTitleField.setPromptText("Course Title");
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().addAll(courseNumberField,courseTitleField);
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		courseCreditsField= new TextField();
		courseCreditsField.setPromptText("Number of Credits");
		textbookAssignedField= new TextField();
		textbookAssignedField.setPromptText("Textbook ISBN");
		box2.getChildren().addAll(courseCreditsField,textbookAssignedField);
		box3=new HBox(30);
		courseDescriptionField= new TextArea();
		courseDescriptionField.setPromptText("Course Description");
		box3.setAlignment(Pos.CENTER);
		box3.getChildren().addAll(courseDescriptionField);
		searchButton= new Button("Insert");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(searchButton);
		courseInsertBox.getChildren().addAll(box1,box2,box3,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		searchButton.setOnAction(e->{
			String courseNumber= courseNumberField.getText();
			String courseTitle= courseTitleField.getText();
			String courseCredits= courseCreditsField.getText();
			String textbookAssigned= textbookAssignedField.getText();
			String courseDescription= courseDescriptionField.getText();
			Course course= new Course(courseTitle,courseNumber,courseDescription,textbookAssigned,courseCredits);
			theBag.insert(course);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Course Information");
			alert2.setHeaderText("Information");
			alert2.setContentText("Course Number: "+course.getCourseNumber()+" Course Title: "+course.getCourseTitle()+
					"\nTextbook: "+course.getTextbookAssigned()+" Credits: "+ course.getNumberOfCredits()+
					"\nCourse Description: "+course.getCourseDescritpion());
			alert2.showAndWait();
			
			
			clearFields();
		});
	}
	
	
	public VBox getCourseInsertBox() {
		return courseInsertBox;
	}

	private void clearFields() {
		courseNumberField.clear();
		courseTitleField.clear();
		courseDescriptionField.clear();
		courseCreditsField.clear();
		textbookAssignedField.clear();
	}
}
