package user;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class ThingsController {

	@FXML Button myThingsmoveMypage_Btn;
	@FXML Button yourThingsmoveMypage_Btn;
	@FXML HBox mtTopHbox;
	@FXML HBox mtBtnColor;
	@FXML Button mtBtn1;
	@FXML Button mtBtn2;
	@FXML Button mtBtn3;
	@FXML Button mtBtn4;
	@FXML Button mtBtn5;
	@FXML Button mtBtn6;
	@FXML Button mtMoveUserHome;
	@FXML HBox ytTopHbox;
	@FXML HBox ytBtnColor;
	@FXML Button ytBtn1;
	@FXML Button ytBtn2;
	@FXML Button ytBtn3;
	@FXML Button ytBtn4;
	@FXML Button ytBtn5;
	@FXML Button ytBtn6;
	@FXML Button ytMoveUserHome;
	@FXML Label mtTitle;
	@FXML Label ytTitle;

	@FXML public void myThingsmoveUserHome() throws Exception {
		
		Stage primaryStage = new Stage();
		Stage stage = (Stage)mtTitle.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/userMain.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void myThingsmoveMyPage() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)mtTitle.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/myPage.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/myPage.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

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
	}

	@FXML public void mtMoveLike() throws Exception{
		Stage primaryStage = new Stage();
		Stage stage = (Stage)mtTitle.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/like.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/like.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

}
