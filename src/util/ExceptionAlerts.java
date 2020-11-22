package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ExceptionAlerts {

	public static void iOException() {
		Alert alert1= new Alert(AlertType.ERROR);
		alert1.setTitle("IO Exception");
		alert1.setHeaderText("Your request was not able to go through");
		alert1.setContentText("There was an error with your IO");
		alert1.showAndWait();
	}
	
	public static void fileNotFound() {
		Alert alert1= new Alert(AlertType.ERROR);
		alert1.setTitle("File Not Found");
		alert1.setHeaderText("Your request was not able to go through");
		alert1.setContentText("Can not find the specified file");
		alert1.showAndWait();
	}
	
	public static void classNotFound() {
		Alert alert1= new Alert(AlertType.ERROR);
		alert1.setTitle("Class Not Found");
		alert1.setHeaderText("Your request was not able to go through");
		alert1.setContentText("Can not find the class");
		alert1.showAndWait();
	}
	
	public static void incorrectPhoneNumber() {
		Alert alert1= new Alert(AlertType.ERROR);
		alert1.setTitle("Phone Number Incorrect");
		alert1.setHeaderText("This is not a proper format for a phone number");
		alert1.setContentText("Please enter a ten digit phone number");
		alert1.showAndWait();
	}
	
	public static void incorrectISBN() {
		Alert alert1= new Alert(AlertType.ERROR);
		alert1.setTitle("Incorrect ISBN");
		alert1.setHeaderText("This is not the proper format for ISBN");
		alert1.setContentText("Please enter 17 characters for an ISBN");
		alert1.showAndWait();
	}
}
