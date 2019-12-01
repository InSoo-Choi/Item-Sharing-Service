package user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ThingsController {

	@FXML Button myThingsmoveMypage_Btn;
	@FXML Button yourThingsmoveMypage_Btn;

	@FXML public void myThingsmoveUserHome() throws Exception {
		
		Stage primaryStage = new Stage();
		Stage stage = (Stage)myThingsmoveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void myThingsmoveMyPage() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)myThingsmoveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/myPage.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void yourThingsmoveMyPage() throws Exception {
		
		Stage primaryStage = new Stage();
		Stage stage = (Stage)yourThingsmoveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/myPage.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void yourThingsmoveUserHome() throws Exception {
		
		Stage primaryStage = new Stage();
		Stage stage = (Stage)yourThingsmoveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

}
