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
import model.Faculty;
import model.MasterCourseBag;
import model.PersonBag;

public class CourseSearchBox {
	private VBox courseSearchBox;
	private HBox box1;
	/*private HBox box2;
	private HBox box3;*/
	private HBox buttonBox;
	
	private TextField courseNumberField;
	/*private TextArea courseTitleField;
	private TextArea courseDescriptionField;
	private TextField courseCreditsField;
	private TextField textbookAssignedField;*/

	
	
	private Button searchButton;

	
	private MasterCourseBag theBag;
	private Course course;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	
	public CourseSearchBox(MasterCourseBag theBag) {
		this.theBag=theBag;
		courseSearchBox= new VBox(30);
		courseSearchBox.setAlignment(Pos.CENTER);
		courseNumberField= new TextField();
		courseNumberField.setPromptText("ID");
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(courseNumberField);
		/*box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		courseTitleField= new TextArea();
		box2.getChildren().addAll(courseTitleField);
		box3=new HBox(30);
		courseCreditsField= new TextField();
		textbookAssignedField= new TextField();
		courseDescriptionField= new TextArea();
		box3.getChildren().addAll(courseCreditsField,courseDescriptionField,textbookAssignedField);*/
		searchButton= new Button("SEARCH");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(searchButton);
		courseSearchBox.getChildren().addAll(box1,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		searchButton.setOnAction(e->{
			String courseNumber= courseNumberField.getText();
			course= (Course)theBag.findByCourseNumber(courseNumber);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Course Information");
			alert2.setHeaderText("Information");
			alert2.setContentText("Course Number: "+course.getCourseNumber()+" Course Title: "+course.getCourseTitle()+
					"\nTextbook: "+course.getTextbookAssigned()+" Credits: "+ course.getNumberOfCredits()+
					"\nCourse Description: "+course.getCourseDescritpion());
			alert2.showAndWait();
			
			
			
		});
	}
	
	
	public VBox getFacultyBox() {
		return courseSearchBox;
	}

	/*private void clearFields() {
		courseNumberField.clear();
		titleField.clear();
		numberOfCreditsField.clear();
		textbookAssignedField.clear();
	}*/
}
