package user;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class UserMainController implements Initializable {

	@FXML Label mypage_name;
	@FXML Label mypage_id;
	@FXML Label mypage_phone;
	
	@FXML Button moveMypage_Btn;
	
	
	@FXML public void moveMyPage() throws Exception {
		
		
		Stage primaryStage = new Stage();
		Stage stage = (Stage)moveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/myPage.fxml"));
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
}
	

	@Override
	public void initialize(URL location, ResourceBundle resources){
	}

}
