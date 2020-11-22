package view;

import java.text.DecimalFormat;

import app.App;
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
import model.Major;
import model.MajorTemplate;
import model.MiniCourseBag;
import model.Name;
import model.PersonBag;
import model.Student;
import util.ExceptionAlerts;

public class StudentInsertBox {
	private VBox studentInsertBox;
	private HBox box1;
	private HBox box2;
	private HBox buttonBox;
	
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField phoneNumberField;
	private ComboBox<Major> majorField;
	
	private Button insertButton;
	
	private PersonBag theBag;
	private Student student;
	private MajorTemplate template;
	private DecimalFormat numberFormat= new DecimalFormat("#.00");
	
	public StudentInsertBox(PersonBag theBag) {
		this.theBag=theBag;
		studentInsertBox= new VBox(30);
		studentInsertBox.setAlignment(Pos.CENTER);
		box1= new HBox(30);
		box1.setAlignment(Pos.CENTER);
		
		firstNameField= new TextField();
		firstNameField.setPromptText("First Name");
		lastNameField= new TextField();
		lastNameField.setPromptText("Last Name");
		phoneNumberField= new TextField();
		phoneNumberField.setPromptText("Phone Number");
		majorField= new ComboBox<>();
		ObservableList<Major> list = FXCollections.observableArrayList(Major.ACC,Major.ANT,Major.ART,Major.ASL,Major.AST,Major.AST,Major.AUT,Major.BIO,Major.BUS,Major.CDC,Major.CHE,Major.CHI,Major.CIN,Major.COL,Major.COM,Major.COT,Major.CRJ,Major.CSE,Major.CST,Major.CUL,Major.CYB,Major.DMA,Major.DNC,Major.DRF,Major.DTE,Major.ECO,Major.EDU,Major.ELT,Major.ENG,Major.ENS,Major.ENV,Major.ESC,Major.ESL,Major.FPT,Major.FRE,Major.GEO,Major.GER,Major.GRD,Major.HIS,Major.HIT,Major.HRM,Major.HSC,Major.HUM,Major.HUS,Major.HVA,Major.IND,Major.INT,Major.ITL,Major.JPN,Major.LAT,Major.LAW,Major.LIB,Major.MAR,Major.MAT,Major.MED,Major.MET,Major.MFT,Major.MKT,Major.MTR,Major.MUS,Major.NUR,Major.OTA,Major.PAR,Major.PED,Major.PFS,Major.PHL,Major.PHY,Major.PNU,Major.POA,Major.POL,Major.PSY,Major.PTA,Major.RDG,Major.RET,Major.RTV,Major.SOC,Major.SPN,Major.THR,Major.TYT,Major.VST,Major.WST);
		majorField.setItems(list);
		box2= new HBox(30);
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(firstNameField,lastNameField,phoneNumberField,majorField);
		insertButton= new Button("INSERT");
		buttonBox= new HBox(30);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(insertButton);
		studentInsertBox.getChildren().addAll(box1,box2,buttonBox);
		
		setEventListeners();
		
	}

	private void setEventListeners() {
		insertButton.setOnAction(e->{
			String firstName=firstNameField.getText();
			String lastName= lastNameField.getText();
			Major major = majorField.getValue();
			Name name= new Name(firstName,lastName);
			String phoneNumber=phoneNumberField.getText();
			if(phoneNumber.length()!=10) {
				ExceptionAlerts.incorrectPhoneNumber();
			}
			else {
			MajorTemplate majorTemplate= new MajorTemplate();
			MiniCourseBag miniCourseBag= majorTemplate.getMiniCourseBag(major);
			Student student= new Student(name,major,miniCourseBag,phoneNumber);
			theBag.insert(student);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Success");
			alert2.setHeaderText("You have successfully added this faculty member");
			alert2.setContentText("First Name: "+student.getName().getFirstName()+" Last Name: "+student.getName().getLastName()+
					"\nPhone Number: "+student.getPhoneNumber()+" GPA: "+ numberFormat.format(student.getGpa(App.getCollege()))+
					"\n" +"ID Number: "+student.getId());
			alert2.showAndWait();
			}
		});
		
	}
	
	public VBox getStudentInsertBox() {
		return studentInsertBox;
	}

	private void clearFields() {
		firstNameField.clear();
		lastNameField.clear();
		phoneNumberField.clear();
		
	}
}
