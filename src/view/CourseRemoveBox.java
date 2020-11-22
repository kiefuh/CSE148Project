package view;

import java.text.DecimalFormat;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Course;
import model.MasterCourseBag;

public class CourseRemoveBox {
	private VBox courseRemoveBox;
	private HBox box1;
	/*private HBox box2;
	private HBox box3;*/
	private HBox buttonBox;
	
	private TextField courseNumberField;
	/*private TextArea courseTitleField;
	private TextArea courseDescriptionField;
	private TextField courseCreditsField;
	private TextField textbookAssignedField;*/

	
	
	private Button removeButton;

	
	private MasterCourseBag theBag;
	private Course course;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	
	public CourseRemoveBox(MasterCourseBag theBag) {
		this.theBag=theBag;
		courseRemoveBox= new VBox(30);
		courseRemoveBox.setAlignment(Pos.CENTER);
		courseNumberField= new TextField();
		courseNumberField.setPromptText("Course Number");
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
		removeButton= new Button("Remove");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(removeButton);
		courseRemoveBox.getChildren().addAll(box1,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		removeButton.setOnAction(e->{
			String courseNumber= courseNumberField.getText();
			course= (Course)theBag.removeByCourseNumber(courseNumber);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Course Information");
			alert2.setHeaderText("You have removed this course");
			alert2.setContentText("Course Number: "+course.getCourseNumber()+" Course Title: "+course.getCourseTitle()+
					"\nTextbook: "+course.getTextbookAssigned()+" Credits: "+ course.getNumberOfCredits()+
					"\nCourse Description: "+course.getCourseDescritpion());
			alert2.showAndWait();
			
			
			
		});
	}
	
	public VBox getCourseRemoveBox() {
		return courseRemoveBox;
	}
}
