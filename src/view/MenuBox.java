package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import app.App;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.CourseHelper;
import util.PersonHelper;
import util.TextbookHelper;

public class MenuBox {
	private MenuBar menuBar;
	
	public MenuBox(Stage stage) {
		menuBar= new MenuBar();
		menuBar.prefWidthProperty().bind(stage.widthProperty());
		
		Menu fileMenu= new Menu("File");
		MenuItem exitMenuItem= new MenuItem("Exit");
		
		Menu textbookMenu=new Menu("Textbooks");
		Menu courseMenu= new Menu("Courses");
		Menu studentMenu= new Menu("Students");
		Menu facultyMenu= new Menu("Faculty");
		Menu saveMenu= new Menu("Save");
		Menu loadMenu= new Menu("Load");
		MenuItem facultySearch= new MenuItem("Search");
		MenuItem facultyInsert= new MenuItem("Insert");
		MenuItem facultyRemoval= new MenuItem("Remove");
		MenuItem facultyExport= new MenuItem("Export");
		MenuItem facultyImport= new MenuItem("Import");
		MenuItem facultyUpdate= new MenuItem("Update");
		MenuItem textbookSearch= new MenuItem("Search");
		MenuItem textbookInsert= new MenuItem("Insert");
		MenuItem textbookRemove= new MenuItem("Remove");
		MenuItem textbookUpdate=new MenuItem("Update");
		MenuItem textbookExport= new MenuItem("Export");
		MenuItem textbookImport= new MenuItem("Import");
		MenuItem studentGrading= new MenuItem("Grade Courses");
		MenuItem studentSearch= new MenuItem("Search");
		MenuItem studentInsert= new MenuItem("Insert");
		MenuItem studentRemove= new MenuItem("Remove");
		MenuItem studentUpdate= new MenuItem("Update");
		MenuItem studentExport= new MenuItem("Export");
		MenuItem studentImport= new MenuItem("Import");
		MenuItem courseSearch= new MenuItem("Search");
		MenuItem courseInsert= new MenuItem("Insert");
		MenuItem courseRemove= new MenuItem("Remove");
		MenuItem courseUpdate= new MenuItem("Update");
		MenuItem courseExport= new MenuItem("Export");
		MenuItem courseImport= new MenuItem("Import");
		MenuItem savePeople= new MenuItem("People");
		MenuItem saveCourses= new MenuItem("Courses");
		MenuItem saveTextbooks= new MenuItem("Textbooks");
		MenuItem loadPeople= new MenuItem("People");
		MenuItem loadCourses= new MenuItem("Courses");
		MenuItem loadTextbooks= new MenuItem("Textbooks");
		
		facultySearch.setOnAction(e->{
			FacultySearchBox facultySearchBox= new FacultySearchBox(App.getCollege().getPersonBag());
			VBox fSearchBox=facultySearchBox.getFacultyBox();
			App.getRoot().setCenter(fSearchBox);
		});
		
		facultyInsert.setOnAction(e->{
			FacultyInsertBox facultyInsertBox= new FacultyInsertBox(App.getCollege().getPersonBag());
			VBox fInsertBox=facultyInsertBox.getFacultyInsertBox();
			App.getRoot().setCenter(fInsertBox);;
		});
		
		facultyRemoval.setOnAction(e->{
			FacultyDeleteBox facultyDeleteBox= new FacultyDeleteBox(App.getCollege().getPersonBag());
			VBox fDeleteBox=  facultyDeleteBox.getFacultyDeleteBox();
			App.getRoot().setCenter(fDeleteBox);
		});
		
		facultyUpdate.setOnAction(e->{
			FacultyUpdateBox facultyUpdateBox= new FacultyUpdateBox(App.getCollege().getPersonBag());
			VBox fUpdateBox= facultyUpdateBox.getFacultyUpdateBox();
			App.getRoot().setCenter(fUpdateBox);
		});
		
		facultyExport.setOnAction(e->{
			TextInputDialog dialog = new TextInputDialog("name");
			dialog.setTitle("Set File Name");
			dialog.setHeaderText("Please input your desired file name in format file.txt");
			dialog.setContentText("File Name");
			dialog.showAndWait();
			String fileName= dialog.getResult();
			DirectoryChooser directoryChooser= new DirectoryChooser();
			String selectedDirectory= directoryChooser.showDialog(stage).getAbsolutePath()+File.separator+fileName;
			PersonHelper.exportFaculty(App.getCollege().getPersonBag(),selectedDirectory);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Export Information");
			alert2.setHeaderText("Faculty Export Complete");
			alert2.setContentText("You have succesfully exported faculty");
			alert2.showAndWait();
			
		});
		
		facultyImport.setOnAction(e->{
			FileChooser fileChooser= new FileChooser();
			File file= fileChooser.showOpenDialog(stage);
			PersonHelper.importFaculty(App.getCollege().getPersonBag(), file);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Import Information");
			alert2.setHeaderText("Faculty Import Complete");
			alert2.setContentText("You have succesfully imported faculty");
			alert2.showAndWait();
		});
		
		textbookSearch.setOnAction(e->{
			TextbookSearchBox textbookSearchBox= new TextbookSearchBox(App.getCollege().getTextbookBag());
			VBox tSearchBox= textbookSearchBox.getTextbookUpdateBox();
			App.getRoot().setCenter(tSearchBox);
		});
		
		textbookInsert.setOnAction(e->{
			TextbookInsertBox textbookInsertBox= new TextbookInsertBox(App.getCollege().getTextbookBag());
			VBox tInsertBox= textbookInsertBox.getTextbookInsertBox();
			App.getRoot().setCenter(tInsertBox);
		});
		
		textbookRemove.setOnAction(e->{
			TextbookRemoveBox textbookRemoveBox= new TextbookRemoveBox(App.getCollege().getTextbookBag());
			VBox tRemoveBox= textbookRemoveBox.getTextbookRemoveBox();
			App.getRoot().setCenter(tRemoveBox);
		});
		
		textbookUpdate.setOnAction(e->{
			TextbookUpdateBox textbookUpdateBox= new TextbookUpdateBox(App.getCollege().getTextbookBag());
			VBox tUpdateBox= textbookUpdateBox.getTextbookUpdateBox();
			App.getRoot().setCenter(tUpdateBox);
		});
		
		textbookExport.setOnAction(e->{
			TextInputDialog dialog = new TextInputDialog("name");
			dialog.setTitle("Set File Name");
			dialog.setHeaderText("Please input your desired file name in format file.txt");
			dialog.setContentText("File Name");
			dialog.showAndWait();
			String fileName= dialog.getResult();
			DirectoryChooser directoryChooser= new DirectoryChooser();
			String fileLocation= directoryChooser.showDialog(stage).getAbsolutePath()+File.separator+fileName;
			TextbookHelper.exportTextbook(App.getCollege().getTextbookBag(),fileLocation);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Export Information");
			alert2.setHeaderText("Textbook Export Complete");
			alert2.setContentText("You have succesfully exported the textbooks");
			alert2.showAndWait();
		});
		
		textbookImport.setOnAction(e->{
			FileChooser fileChooser= new FileChooser();
			File file= fileChooser.showOpenDialog(stage);
			TextbookHelper.importTextbooks(App.getCollege().getTextbookBag(),file);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Import Information");
			alert2.setHeaderText("Textbook Import Complete");
			alert2.setContentText("You have succesfully Imported the textbooks");
			alert2.showAndWait();
		});
		
		studentGrading.setOnAction(e->{
			StudentCourseBox studentCourseBox= new StudentCourseBox(App.getCollege().getPersonBag());
			VBox sCourseBox= studentCourseBox.getStudentCourseBox();
			App.getRoot().setCenter(sCourseBox);
		});
		
		studentSearch.setOnAction(e->{
			StudentSearchBox studentSearchBox= new StudentSearchBox(App.getCollege().getPersonBag());
			VBox stuSearchBox= studentSearchBox.getStudentSearchBox();
			App.getRoot().setCenter(stuSearchBox);
		});
		
		studentInsert.setOnAction(e->{
			StudentInsertBox studentInsertBox= new StudentInsertBox(App.getCollege().getPersonBag());
			VBox stuInsertBox= studentInsertBox.getStudentInsertBox();
			App.getRoot().setCenter(stuInsertBox);
		});
		
		studentRemove.setOnAction(e->{
			StudentRemoveBox studentRemoveBox= new StudentRemoveBox(App.getCollege().getPersonBag());
			VBox stuRemoveBox= studentRemoveBox.getStudentRemoveBox();
			App.getRoot().setCenter(stuRemoveBox);
		});
		
		studentUpdate.setOnAction(e->{
			StudentUpdateBox studentUpdateBox= new StudentUpdateBox(App.getCollege().getPersonBag());
			VBox stuUpdateBox= studentUpdateBox.getStudentUpdateBox();
			App.getRoot().setCenter(stuUpdateBox);
		});
		
		studentExport.setOnAction(e->{
			TextInputDialog dialog = new TextInputDialog("name");
			dialog.setTitle("Set File Name");
			dialog.setHeaderText("Please input your desired file name in format file.txt");
			dialog.setContentText("File Name");
			dialog.showAndWait();
			String fileName= dialog.getResult();
			DirectoryChooser directoryChooser= new DirectoryChooser();
			String fileLocation= directoryChooser.showDialog(stage).getAbsolutePath()+File.separator+fileName;
			PersonHelper.exportStudent(App.getCollege().getPersonBag(),fileLocation);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Export Information");
			alert2.setHeaderText("Textbook Export Complete");
			alert2.setContentText("You have succesfully exported textbook");
			alert2.showAndWait();
		});
		
		studentImport.setOnAction(e->{
			FileChooser fileChooser= new FileChooser();
			File file= fileChooser.showOpenDialog(stage);
			PersonHelper.importStudent(App.getCollege().getPersonBag(), file);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Import Information");
			alert2.setHeaderText("Faculty Import Complete");
			alert2.setContentText("You have succesfully imported students");
			alert2.showAndWait();
		});
		
		courseSearch.setOnAction(e->{
			CourseSearchBox courseSearchBox= new CourseSearchBox(App.getCollege().getMasterCourseBag());
			VBox cSearchBox= courseSearchBox.getFacultyBox();
			App.getRoot().setCenter(cSearchBox);
		});
		
		courseInsert.setOnAction(e->{
			CourseInsertBox courseInsertBox= new CourseInsertBox(App.getCollege().getMasterCourseBag());
			VBox cInsertBox = courseInsertBox.getCourseInsertBox();
			App.getRoot().setCenter(cInsertBox);
		});
		
		courseRemove.setOnAction(e->{
			CourseRemoveBox courseRemoveBox= new CourseRemoveBox(App.getCollege().getMasterCourseBag());
			VBox cRemoveBox= courseRemoveBox.getCourseRemoveBox();
			App.getRoot().setCenter(cRemoveBox);
		});
		
		courseUpdate.setOnAction(e->{
			CourseUpdateBox courseUpdateBox= new CourseUpdateBox(App.getCollege().getMasterCourseBag());
			VBox cUpdateBox= courseUpdateBox.getCourseUpdateBox();
			App.getRoot().setCenter(cUpdateBox);
		});
		
		courseExport.setOnAction(e->{
			TextInputDialog dialog = new TextInputDialog("name");
			dialog.setTitle("Set File Name");
			dialog.setHeaderText("Please input your desired file name in format file.txt");
			dialog.setContentText("File Name");
			dialog.showAndWait();
			String fileName= dialog.getResult();
			DirectoryChooser directoryChooser= new DirectoryChooser();
			String fileLocation= directoryChooser.showDialog(stage).getAbsolutePath()+File.separator+fileName;
			CourseHelper.exportCourses(App.getCollege().getMasterCourseBag(),fileLocation);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Export Information");
			alert2.setHeaderText("Course Export Complete");
			alert2.setContentText("You have succesfully exported courses");
			alert2.showAndWait();
		});
		
		courseImport.setOnAction(e->{
			FileChooser fileChooser= new FileChooser();
			File file= fileChooser.showOpenDialog(stage);
			CourseHelper.importCourses(App.getCollege().getMasterCourseBag(), file);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Import Information");
			alert2.setHeaderText("Course Import Complete");
			alert2.setContentText("You have succesfully imported courses");
			alert2.showAndWait();
		});
		
		savePeople.setOnAction(e->{
			TextInputDialog dialog = new TextInputDialog("name");
			dialog.setTitle("Set File Name");
			dialog.setHeaderText("Please input your desired file name in format file.dat");
			dialog.setContentText("File Name");
			dialog.showAndWait();
			String fileName= dialog.getResult();
			DirectoryChooser directoryChooser= new DirectoryChooser();
			String fileLocation= directoryChooser.showDialog(stage).getAbsolutePath()+File.separator+fileName;
			PersonHelper.saveMenu(App.getCollege().getPersonBag(),fileLocation);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Save Information");
			alert2.setHeaderText("Save Complete");
			alert2.setContentText("You have succesfully saved");
			alert2.showAndWait();
		});
		
		saveCourses.setOnAction(e->{
			TextInputDialog dialog = new TextInputDialog("name");
			dialog.setTitle("Set File Name");
			dialog.setHeaderText("Please input your desired file name in format file.dat");
			dialog.setContentText("File Name");
			dialog.showAndWait();
			String fileName= dialog.getResult();
			DirectoryChooser directoryChooser= new DirectoryChooser();
			String fileLocation= directoryChooser.showDialog(stage).getAbsolutePath()+File.separator+fileName;
			CourseHelper.saveMenu(App.getCollege().getMasterCourseBag(),fileLocation);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Save Information");
			alert2.setHeaderText("Save Complete");
			alert2.setContentText("You have succesfully saved");
			alert2.showAndWait();
		});
		
		saveTextbooks.setOnAction(e->{
			TextInputDialog dialog = new TextInputDialog("name");
			dialog.setTitle("Set File Name");
			dialog.setHeaderText("Please input your desired file name in format file.dat");
			dialog.setContentText("File Name");
			dialog.showAndWait();
			String fileName= dialog.getResult();
			DirectoryChooser directoryChooser= new DirectoryChooser();
			String fileLocation= directoryChooser.showDialog(stage).getAbsolutePath()+File.separator+fileName;
			TextbookHelper.saveMenu(App.getCollege().getTextbookBag(),fileLocation);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Save Information");
			alert2.setHeaderText("Save Complete");
			alert2.setContentText("You have succesfully saved");
			alert2.showAndWait();
		});
		
		loadPeople.setOnAction(e->{
			FileChooser fileChooser= new FileChooser();
			File file= fileChooser.showOpenDialog(stage);
			PersonHelper.loadMenu(file);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Load Information");
			alert2.setHeaderText("Loading Complete");
			alert2.setContentText("You have succesfully loaded");
			alert2.showAndWait();
		});
		
		loadCourses.setOnAction(e->{
			FileChooser fileChooser= new FileChooser();
			File file= fileChooser.showOpenDialog(stage);
			CourseHelper.loadMenu(file);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Load Information");
			alert2.setHeaderText("Loading Complete");
			alert2.setContentText("You have succesfully loaded");
			alert2.showAndWait();
		});
		
		loadTextbooks.setOnAction(e->{
			FileChooser fileChooser= new FileChooser();
			File file= fileChooser.showOpenDialog(stage);
			TextbookHelper.loadMenu(file);
			Alert alert2= new Alert(AlertType.INFORMATION);
			alert2.setTitle("Load Information");
			alert2.setHeaderText("Loading Complete");
			alert2.setContentText("You have succesfully loaded");
			alert2.showAndWait();
		});
		exitMenuItem.setOnAction(e->{
			TextbookHelper.save(App.getCollege().getTextbookBag());
			CourseHelper.save(App.getCollege().getMasterCourseBag());
			
			PersonHelper.save(App.getCollege().getPersonBag());
			Platform.exit();
		});
		/*
		 * courseMenu.setOnAction(e->{ CourseBox courseBox= new
		 * CourseBox(App.getCollege().getMasterCourseBag()); VBox
		 * classBox=courseBox.getCourseBox(); App.getRoot().setCenter(classBox); });
		 * 
		 * textbookMenu.setOnAction(e->{ TextbookBox textbookBox= new
		 * TextbookBox(App.getCollege().getTextbookBag()); VBox bookBox=
		 * textbookBox.getTextbookBox(); App.getRoot().setCenter(bookBox); });
		 */
		
		/*
		 * studentMenu.setOnAction(e->{ StudentBox studentBox= new
		 * StudentBox(App.getCollege().getPersonBag()); VBox stBox=
		 * studentBox.getStudentBox(); App.getRoot().setCenter(stBox); });
		 */
		
//		facultyMenu.setOnAction(e->{
//			FacultyBox facultyBox= new FacultyBox(App.getCollege().getPersonBag());
//			VBox fcBox= facultyBox.getFacultyBox();
//			App.getRoot().setCenter(fcBox);
//		});
		courseMenu.getItems().addAll(courseSearch, new SeparatorMenuItem(),courseInsert, new SeparatorMenuItem(), courseRemove, new SeparatorMenuItem(),courseUpdate, new SeparatorMenuItem(), courseExport, new SeparatorMenuItem(),courseImport);
		
		studentMenu.getItems().addAll(studentSearch, new SeparatorMenuItem(),studentGrading,new SeparatorMenuItem(),studentInsert,new SeparatorMenuItem(),studentRemove,new SeparatorMenuItem(),studentUpdate,new SeparatorMenuItem(),studentExport,new SeparatorMenuItem(),studentImport);
		
		facultyMenu.getItems().addAll(facultySearch, new SeparatorMenuItem(),facultyInsert,new SeparatorMenuItem(),facultyRemoval,new SeparatorMenuItem(),facultyUpdate, new SeparatorMenuItem(),facultyExport, new SeparatorMenuItem(), facultyImport);
		
		textbookMenu.getItems().addAll(textbookSearch, new SeparatorMenuItem(),textbookInsert, new SeparatorMenuItem(),textbookRemove, new SeparatorMenuItem(), textbookUpdate,new SeparatorMenuItem(),textbookExport,new SeparatorMenuItem(),textbookImport);
		
		saveMenu.getItems().addAll(savePeople, new SeparatorMenuItem(),saveCourses, new SeparatorMenuItem(),saveTextbooks);
		
		loadMenu.getItems().addAll(loadPeople, new SeparatorMenuItem(),loadCourses, new SeparatorMenuItem(),loadTextbooks);
		
		fileMenu.getItems().addAll(
							courseMenu,new SeparatorMenuItem()
							,studentMenu,new SeparatorMenuItem(),textbookMenu,new SeparatorMenuItem(), facultyMenu,new SeparatorMenuItem(), saveMenu, new SeparatorMenuItem(),loadMenu, new SeparatorMenuItem(),
							exitMenuItem);
		
		menuBar.getMenus().addAll(fileMenu);
	}


	public MenuBar getMenuBar() {
		return menuBar;
	}
}
