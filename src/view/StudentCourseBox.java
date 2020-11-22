package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.CourseGrade;
import model.CourseType;
import model.MiniCourse;
import model.MiniCourseBag;
import model.PersonBag;
import model.Student;
import model.Title;

public class StudentCourseBox {
	private VBox studentCourseBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;

	
	private TextField idField;
	private ComboBox<CourseType> courseType;
	private ComboBox<CourseGrade> courseGrade;


	private Button searchButton;
	private Button getInfoButton;
	private Button setInfoButton;
	ListView<String> miniCourseView;
	private PersonBag theBag;
	private Student student;
	private String miniCourseNumber;

	public StudentCourseBox(PersonBag theBag) {
		this.theBag = theBag;
		studentCourseBox = new VBox(30);
		studentCourseBox.setAlignment(Pos.CENTER);
		idField = new TextField();
		idField.setPromptText("ID");
		courseGrade = new ComboBox<>();
		courseType = new ComboBox<>();
		miniCourseView = new ListView<String>();
		ObservableList<CourseType> courseTypeList = FXCollections.observableArrayList(CourseType.NEED_TO_TAKE,CourseType.TAKING,CourseType.TAKEN);
		courseType.setItems(courseTypeList);
		ObservableList<CourseGrade> courseGradeList = FXCollections.observableArrayList(CourseGrade.A,CourseGrade.B_PLUS,CourseGrade.B,CourseGrade.C_PLUS,CourseGrade.C,CourseGrade.D_PLUS,CourseGrade.D,CourseGrade.F,CourseGrade.NO_GRADE);
		courseGrade.setItems(courseGradeList);
		box1 = new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().addAll(idField, miniCourseView, courseType, courseGrade);
		box2 = new HBox(30);
		box2.setAlignment(Pos.CENTER);
		searchButton = new Button("SEARCH");
		getInfoButton = new Button("Course Attributes");
		setInfoButton= new Button ("Set Attributes");
		buttonBox = new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(searchButton, getInfoButton,setInfoButton);
		studentCourseBox.getChildren().addAll(box1, box2, buttonBox);

		setEventListeners();

	}

	private void setEventListeners() {

		searchButton.setOnAction(e -> {

			miniCourseView.getItems().setAll(new ArrayList<String>());
			String id = idField.getText();
			student = (Student) theBag.findByIdNumberStudent(id);
			if (student != null) {
				ArrayList<String> list = new ArrayList<>();
				MiniCourseBag bag = student.getMiniCourseBag();
				for (int i = 0; i < bag.getNElems(); i++) {
					list.add(bag.get(i).getMiniCourseNumber());
				}
				miniCourseView.getItems().addAll(list);
			}
			/*String miniCourseNumber=miniCourseView.getSelectionModel().getSelectedItem();
			MiniCourse miniCourse= student.getMiniCourseBag().Find(miniCourseNumber);
			courseGrade.setValue(miniCourse.getCourseGrade());
			courseType.setValue(miniCourse.getCourseType());*/
		});


		getInfoButton.setOnAction(e->{
			miniCourseNumber=miniCourseView.getSelectionModel().getSelectedItem();
			MiniCourse miniCourse= student.getMiniCourseBag().Find(miniCourseNumber);
			courseGrade.setValue(miniCourse.getCourseGrade());
			courseType.setValue(miniCourse.getCourseType());
			
		});
		
		setInfoButton.setOnAction(e->{
			CourseGrade courseGrades=courseGrade.getValue();
			CourseType courseTypes=courseType.getValue();
			MiniCourse miniCourse=student.getMiniCourseBag().Find(miniCourseNumber);
			miniCourse.setCourseType(courseTypes);
			miniCourse.setCourseGrade(courseGrades);
			
		});
		


	}

	public VBox getStudentCourseBox() {
		return studentCourseBox;
	}
}
