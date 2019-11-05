package home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RootController implements Initializable {

	@FXML Button user;
	@FXML Button manager;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	@FXML public void moveUser() {
		Stage newStage = new Stage();
		Stage stage = (Stage)user.getScene().getWindow();
		
		try {
			Parent second = FXMLLoader.load(getClass().getResource("login.fxml"));
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

}
