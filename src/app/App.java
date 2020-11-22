package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.College;
import model.Course;
import model.CourseGrade;
import model.CourseType;
import model.Major;
import model.MajorTemplate;
import model.MasterCourseBag;
import model.MiniCourse;
import model.MiniCourseBag;
import model.Name;
import model.Person;
import model.PersonBag;
import model.PublisherBag;
import model.Student;
import model.TextbookBag;
import util.CourseHelper;
import util.NameBag;
import util.NameFactory;
import util.NameHelper;
import util.PersonFactory;
import util.PersonHelper;
import util.TextbookHelper;
import view.MenuBox;
import view.StudentBox;
import view.TextbookBox;

public class App extends Application {
	public static void main(String[] args){
		launch(args);
	}
	static MasterCourseBag masterCourseBag= new MasterCourseBag(100000);
	static NameBag nameBag= new NameBag(10000);
	static College college= new College(4000,5000,10000);
	static BorderPane root= new BorderPane();
	static TextbookBag textbookBag= new TextbookBag(100000);
	static PersonBag personBag= new PersonBag(10000);
	public static BorderPane getRoot() {
		return root;
	}
	public static College getCollege() {
		return college;
	}
	public static NameBag getNameBag() {
		return nameBag;
	}
	static PublisherBag publisherBag= new PublisherBag(300);
	public static PublisherBag getPublisherBag() {
		return publisherBag;
	}
	@Override
	public void init() throws ClassNotFoundException, IOException {
		//TextbookHelper.importPublisherData(publisherBag, "inputData/Publishers.txt");
		/*try {
			NameHelper.importNames(nameBag, "inputData/First Names.txt", "inputData/Last Names.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		}
		NameHelper.save(nameBag);
		NameFactory nf= new NameFactory(nameBag);*/
		//CourseHelper.importData(masterCourseBag, "inputData/Course_Inventory.txt");
		//CourseHelper.save(masterCourseBag);
		college.setMasterCourseBag(CourseHelper.load());
		college.setTextbookBag(TextbookHelper.load());
		college.setPersonBag(PersonHelper.load());
		/*PersonFactory pf= new PersonFactory(personBag);
		pf.fillPersonBagStudents(personBag, 3000);
		pf.fillPersonBagFaculty(personBag, 1700);*/
		//PersonHelper.importFaculty(personBag, "data/faculty.txt");
		//college.setPersonBag(personBag);
		Person.setIdCounter(App.college.getPersonBag().getNElems()+1);
		
		/*try {
			TextbookHelper.importData(textbookBag, "inputData/textbook_titles.txt", "inputData/textbook_isbns.txt", Math.random()*200);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Alert alert= new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText("File not found");
			alert.setContentText("Please check the file location is correct");

			alert.showAndWait();
		}*/
		//college.setTextbookBag(textbookBag);
		//TextbookHelper.save(textbookBag);
		/*MiniCourseBag theBag;
		MiniCourseBag theBag2;
		MajorTemplate template= new MajorTemplate();
		Major major= Major.CSE;*/
		//theBag=template.getMiniCourseBag(major);
		//theBag2=template.getMiniCourseBag(Major.CST);
		//theBag.display();
		//theBag2.display();
		//Name name= new Name("John","Jones");
		//Student s1= new Student(name,major,theBag,pf.emitARandomPhoneNumber());
		//s1.getMiniCourseBag().display();
		//s1.getMiniCourseBag().Find("CSE118").setCourseGrade(CourseGrade.B);
		//s1.getMiniCourseBag().Find("CSE118").setCourseType(CourseType.TAKEN);

		//System.out.println(s1.getGpa(App.getCollege()));
		//PersonHelper.export(App.getCollege().getPersonBag());
		//PersonHelper.importFaculty(App.getCollege().getPersonBag(), "data/faculty.txt");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MenuBox menuBox= new MenuBox(primaryStage);
		root.setTop(menuBox.getMenuBar());
		Scene scene= new Scene(root, 600,500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
