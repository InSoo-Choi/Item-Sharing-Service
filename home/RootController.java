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
	@FXML Button UserSignUp;
	@FXML Button home;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	@FXML public void moveUser() throws Exception{
		Stage primaryStage = new Stage();
		Stage stage = (Stage)user.getScene().getWindow();

			Parent second = FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene sc = new Scene(second);
			 primaryStage.setScene(sc);
	         primaryStage.show();
			 stage.close();
	}
	
	@FXML public void moveManager() throws Exception{
		Stage primaryStage = new Stage();
		Stage stage = (Stage)user.getScene().getWindow();

			Parent second = FXMLLoader.load(getClass().getResource("managerLogin.fxml"));
			Scene sc = new Scene(second);
			 primaryStage.setScene(sc);
	         primaryStage.show();
			 stage.close();
	}


	@FXML public void submitUserSignup() {
		
	}

	@FXML public void checkExistID() {
		
	}

	@FXML public void goUserSignUp() throws Exception{
		
		Stage primaryStage = new Stage();
			Parent signUp = FXMLLoader.load(getClass().getResource("UserSignup.fxml"));
			 primaryStage.setScene(new Scene(signUp));
	         primaryStage.show();
	         
	         Stage stage = (Stage)UserSignUp.getScene().getWindow();
	         stage.close();
	}


	@FXML public void goHome() throws Exception{
		Stage primaryStage = new Stage();
		Parent signUp = FXMLLoader.load(getClass().getResource("first.fxml"));
		 primaryStage.setScene(new Scene(signUp));
         primaryStage.show();
         
         Stage stage = (Stage)home.getScene().getWindow();
         stage.close();
	}


}
