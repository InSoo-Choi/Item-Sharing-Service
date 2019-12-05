package user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class yourThingsController {

	@FXML HBox ytTopHbox;
	@FXML Label ytTitle;
	@FXML AnchorPane ytBackColor;
	@FXML HBox ytBtnColor;
	@FXML Button ytBtn1;
	@FXML Button ytBtn2;
	@FXML Button ytBtn4;
	@FXML Button ytBtn3;
	@FXML Button ytBtn5;
	@FXML Button ytBtn6;
	@FXML Line ytLine1;
	@FXML Label ytYourthingsLabel;
	@FXML Line ytLine2;
	@FXML Button ytReturnBtn;
	@FXML Button yourThingsmoveMypage_Btn;
	@FXML Button ytMoveUserHome;

	@FXML public void yourThingsmoveMyPage() throws Exception {
		
		Stage primaryStage = new Stage();
		Stage stage = (Stage)ytTitle.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/myPage.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/myPage.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}


	@FXML public void yourThingsmoveUserHome() throws Exception {
		
		Stage primaryStage = new Stage();
		Stage stage = (Stage)ytTitle.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/userMain.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}
	
	@FXML public void ytMoveLike() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)ytTitle.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/like.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/like.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	};

}
