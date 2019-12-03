package user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class postController {

	@FXML Button showonepostmoveMypage_Btn;

	@FXML public void showonepostmoveMyPage() throws Exception{
		 	Stage primaryStage = new Stage();
			Stage stage = (Stage)showonepostmoveMypage_Btn.getScene().getWindow();
			Parent ob = FXMLLoader.load(getClass().getResource("templates/myPage.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void moveUserHome() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)showonepostmoveMypage_Btn.getScene().getWindow();
		Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
		Scene sc = new Scene(ob);
		primaryStage.setScene(sc);
        primaryStage.show();
		stage.close();
	}

}
