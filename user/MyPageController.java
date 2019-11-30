package user;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import static home.MyInfo.*;

public class MyPageController implements Initializable {

	@FXML Label mypage_name;
	@FXML Label mypage_id;
	@FXML Label mypage_phone;
	
	void init() {
		mypage_id.setText(my_id);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();
		
	}
	
	
}
