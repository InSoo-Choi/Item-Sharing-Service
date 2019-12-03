package user;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class yourThingsController {

	@FXML Button yourThingsmoveMypage_Btn;

	@FXML public void yourThingsmoveMyPage() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)yourThingsmoveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/myPage.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

}
