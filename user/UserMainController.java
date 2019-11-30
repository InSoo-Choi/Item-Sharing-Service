package user;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;


public class UserMainController implements Initializable {
	
	@FXML Button moveMypage_Btn;
	@FXML TextField post_title;
	@FXML DatePicker limit_date;
	@FXML TextField price;
	@FXML TextArea contents;
	
	
	@FXML public void moveMyPage() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)moveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/myPage.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
}
	@FXML public void moveAdd() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)moveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/addItem.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}
	@FXML public void moveUserHome() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)post_title.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}
	
	@FXML public void postSubmit() {}

	@Override
	public void initialize(URL location, ResourceBundle resources){
	}


}
