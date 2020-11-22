package view;

import java.io.IOException;

import app.App;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Course;
import model.MasterCourseBag;
import model.Textbook;
import model.TextbookBag;
import util.CourseHelper;
import util.TextbookHelper;

public class CourseBox {
	private VBox courseBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	private TextField titleField;
	private TextField courseNumberField;
	private TextField textbookAssignedField;
	private TextField numberOfCreditsField;
	private TextField courseDescriptionField;
	
	private Button insertButton;
	private Button searchButton;
	private Button removeButton;
	private Button updateButton;
	private Button saveButton;
	
	private MasterCourseBag theBag;
	private Course course;
	
	public CourseBox(MasterCourseBag theBag) {
		this.theBag=theBag;
		courseBox= new VBox(30);
		courseBox.setAlignment(Pos.CENTER);
		courseNumberField= new TextField();
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(courseNumberField);
		titleField= new TextField();
		textbookAssignedField= new TextField();
		numberOfCreditsField= new TextField();
		courseDescriptionField= new TextField();
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(titleField,textbookAssignedField,numberOfCreditsField,courseDescriptionField);
		insertButton= new Button("INSERT");
		searchButton= new Button("SEARCH");
		removeButton= new Button("REMOVE");
		updateButton= new Button("UPDATE");
		saveButton= new Button("SAVE");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertButton,searchButton,removeButton,updateButton,saveButton);
		courseBox.getChildren().addAll(box1,box2,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		insertButton.setOnAction(e->{
			String courseNumber=courseNumberField.getText();
			String title=titleField.getText();
			String numCredits= numberOfCreditsField.getText();
			String textbookAssigned=textbookAssignedField.getText();
			String courseDescription=courseDescriptionField.getText();
			Course course= new Course(title, courseNumber,courseDescription,textbookAssigned,numCredits);
			theBag.insert(course);
		});
		
		searchButton.setOnAction(e->{
			String courseNumber= courseNumberField.getText();
			course= theBag.findByCourseNumber(courseNumber);
			titleField.setText(course.getCourseTitle());
			textbookAssignedField.setText(course.getTextbookAssigned());
			numberOfCreditsField.setText(String.valueOf(course.getNumberOfCredits()));
			courseDescriptionField.setText(course.getCourseDescritpion());
		});
		
		saveButton.setOnAction(e->{
			CourseHelper.save(App.getCollege().getMasterCourseBag());
		});
	}
	
	public VBox getCourseBox() {
		return courseBox;
	}

	private void clearFields() {
		courseNumberField.clear();
		titleField.clear();
		numberOfCreditsField.clear();
		textbookAssignedField.clear();
	}
}
