package user;

import java.net.URL;
import java.util.ResourceBundle;

import database.DBMembers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static home.MyInfo.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MyPageController implements Initializable {

	@FXML Label mypage_name;
	@FXML Label mypage_id;
	@FXML Label mypage_phone;
	
	static String[] mypage_info = DBMembers.load_myInfo(my_id);

	
	void init() {
		mypage_id.setText(my_id);
		mypage_name.setText(mypage_info[0]);
		mypage_phone.setText(mypage_info[1]);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();
		
	}

	@FXML public void moveUserHome() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)mypage_id.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void moveMyThings() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)mypage_id.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/myThings.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void moveYourThings() throws Exception {
		
		Stage primaryStage = new Stage();
		Stage stage = (Stage)mypage_id.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/yourThings.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void myThingsmoveUserHome() {}

	@FXML public void yourThingsmoveMyPage() {}

	@FXML public void yourThingsmoveUserHome() {}

	@FXML public void myThingsmoveMyPage() {}
	
	
}
