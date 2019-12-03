package user;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class myThingsController {

	@FXML Button myThingsmoveMypage_Btn;

	@FXML public void myThingsmoveUserHome() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)myThingsmoveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/myPage.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

}
