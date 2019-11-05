package home;

import java.io.IOException;
import home.Main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class RootController implements Initializable {

	@FXML Button user;
	@FXML Button manager;
	@FXML TextField getID;
	@FXML PasswordField getPW;
	@FXML TextField getPhoneNum;
	@FXML TextField getName;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	@FXML public void moveUser() {
		Stage newStage = new Stage();
		Stage stage = (Stage)user.getScene().getWindow();
		
		try {
			Parent second = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene sc = new Scene(second);
			 newStage.setScene(sc);
	         newStage.show();
			stage.hide();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML public void moveManager() {
		
	}

	@FXML public void submitUserSignup() {
		
	}

	@FXML public void goBackHome(Stage primaryStage) {
		primaryStage.show();
	}

	@FXML public void checkExistID() {
		
	}

	@FXML public void goUserSignUp() {
		Stage newStage = new Stage();
		Stage stage = (Stage)user.getScene().getWindow();
		
		try {
			Parent third = FXMLLoader.load(getClass().getResource("MakeAccount.fxml"));
			Scene sc = new Scene(third);
			 newStage.setScene(sc);
	         newStage.show();
			stage.hide();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@FXML public void goBackHome() {}

}
