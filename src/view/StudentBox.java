package view;

import java.io.IOException;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Course;
import model.Major;
import model.MajorTemplate;
import model.MasterCourseBag;
import model.Name;
import model.PersonBag;
import model.Student;
import util.CourseHelper;

public class StudentBox {
	private VBox studentBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField phoneNumberField;
	private TextField idField;
	private TextField gpaField;
	private ComboBox<Major> majorField;
	private TextField miniCourseField;
	
	private Button insertButton;
	private Button searchButton;
	private Button removeButton;
	private Button updateButton;
	private Button saveButton;
	
	private PersonBag theBag;
	private Student student;
	private MajorTemplate template;
	
	public StudentBox(PersonBag theBag) {
		this.theBag=theBag;
		studentBox= new VBox(30);
		studentBox.setAlignment(Pos.CENTER);
		idField= new TextField();
		idField.setPromptText("ID");
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(idField);
		firstNameField= new TextField();
		firstNameField.setPromptText("First Name");
		lastNameField= new TextField();
		lastNameField.setPromptText("Last Name");
		phoneNumberField= new TextField();
		phoneNumberField.setPromptText("Phone Number");
		gpaField= new TextField();
		gpaField.setPromptText("Gpa");
		majorField= new ComboBox<>();
		ObservableList<Major> list = FXCollections.observableArrayList(Major.ACC,Major.ANT,Major.ART,Major.ASL,Major.AST,Major.AST,Major.AUT,Major.BIO,Major.BUS,Major.CDC,Major.CHE,Major.CHI,Major.CIN,Major.COL,Major.COM,Major.COT,Major.CRJ,Major.CSE,Major.CST,Major.CUL,Major.CYB,Major.DMA,Major.DNC,Major.DRF,Major.DTE,Major.ECO,Major.EDU,Major.ELT,Major.ENG,Major.ENS,Major.ENV,Major.ESC,Major.ESL,Major.FPT,Major.FRE,Major.GEO,Major.GER,Major.GRD,Major.HIS,Major.HIT,Major.HRM,Major.HSC,Major.HUM,Major.HUS,Major.HVA,Major.IND,Major.INT,Major.ITL,Major.JPN,Major.LAT,Major.LAW,Major.LIB,Major.MAR,Major.MAT,Major.MED,Major.MET,Major.MFT,Major.MKT,Major.MTR,Major.MUS,Major.NUR,Major.OTA,Major.PAR,Major.PED,Major.PFS,Major.PHL,Major.PHY,Major.PNU,Major.POA,Major.POL,Major.PSY,Major.PTA,Major.RDG,Major.RET,Major.RTV,Major.SOC,Major.SPN,Major.THR,Major.TYT,Major.VST,Major.WST);
		majorField.setItems(list);
		miniCourseField=new TextField();
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(firstNameField,lastNameField,phoneNumberField,gpaField,majorField,miniCourseField);
		insertButton= new Button("INSERT");
		searchButton= new Button("SEARCH");
		removeButton= new Button("REMOVE");
		updateButton= new Button("UPDATE");
		saveButton= new Button("SAVE");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertButton,searchButton,removeButton,updateButton,saveButton);
		studentBox.getChildren().addAll(box1,box2,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		insertButton.setOnAction(e->{
			String firstName=firstNameField.getText();
			String lastName= lastNameField.getText();
			Major major = majorField.getValue();
			Name name= new Name(firstName,lastName);
			String phoneNumber=phoneNumberField.getText();
			Student student= new Student(name,major,null,phoneNumber);
			theBag.insert(student);
			System.out.println();
			idField.setText(student.getId());
		});
		
		searchButton.setOnAction(e->{
			String id= idField.getText();
			student= (Student)theBag.findByIdNumberStudent(id);
			firstNameField.setText(student.getName().getFirstName());
			lastNameField.setText(student.getName().getLastName());
			phoneNumberField.setText(student.getPhoneNumber());
			gpaField.setText(String.valueOf(student.getGpa(App.getCollege())));
			majorField.setValue(student.getMajor());
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
	
	public VBox getStudentBox() {
		return studentBox;
	}

	/*private void clearFields() {
		courseNumberField.clear();
		titleField.clear();
		numberOfCreditsField.clear();
		textbookAssignedField.clear();
	}*/
}
