package user;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ComboBox;


public class UserMainController implements Initializable {
	
	@FXML Button moveMypage_Btn;
	@FXML ComboBox<String> kinds;
	
	
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
	
	@FXML public void moveLike() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)moveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/like.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources){

	}

}
