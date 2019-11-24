package home;


import java.net.URL;
import java.util.ResourceBundle;

import database.DBMembers;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RootController implements Initializable {

	@FXML Button user;
	@FXML Button manager;
	@FXML TextField getID;
	@FXML PasswordField getPW;
	@FXML TextField getPhoneNum;
	@FXML TextField getName;
	@FXML Button UserSignUp;
	@FXML Button home;
	@FXML PasswordField inputPW;
	@FXML TextField inputID;
	@FXML Button loginOK;
	
	int checkNum = -1;
	@FXML PasswordField confirmPW;
	@FXML Button submitBtn;
	@FXML Label title;
	@FXML VBox vbox;
	@FXML Label UserLogin;
	@FXML ImageView firstBackImage;
	@FXML Pane firstBackColor;
	@FXML ImageView loginBackImage;
	@FXML Pane loginBackColor;
	@FXML ImageView usersignupBackImage;
	@FXML Pane usersignupBackColor;
	@FXML ImageView managerloginBackImage;
	@FXML Pane managerloginBackColor;
	@FXML TextField inputManagerID;
	@FXML PasswordField inputManagerPW;
	@FXML Button home2;
	@FXML Button checkExistBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	@FXML public void moveUser() throws Exception{
		Stage primaryStage = new Stage();
		Stage stage = (Stage)user.getScene().getWindow();

			Parent second = FXMLLoader.load(getClass().getResource("templates/login.fxml"));
			Scene sc = new Scene(second);
			sc.getStylesheets().add(getClass().getResource("statics/login.css").toExternalForm());
			 primaryStage.setScene(sc);
	         primaryStage.show();
			 stage.close();
	}
	
	@FXML public void moveManager() throws Exception{
		Stage primaryStage = new Stage();
		Stage stage = (Stage)user.getScene().getWindow();

			Parent second = FXMLLoader.load(getClass().getResource("templates/managerLogin.fxml"));
			Scene sc = new Scene(second);
			primaryStage.setScene(sc);
	         primaryStage.show();
			 stage.close();
	}
	
	
	@FXML public void UserLogin(ActionEvent event) throws Exception {
		
		String PWfromDB = database.DBMembers.members_load(inputID.getText());
		
		if(PWfromDB.equals(inputPW.getText())) {
			System.out.println("login success");
			Stage primaryStage = new Stage();
			Stage stage = (Stage)loginOK.getScene().getWindow();

				Parent UserPage = FXMLLoader.load(getClass().getResource("/user/UserMain.fxml"));
				Scene sc = new Scene(UserPage);
				 primaryStage.setScene(sc);
		         primaryStage.show();
				 stage.close();
		}
		else {
			System.out.println("login fail");
		}
	}

	
	//회원가입
	@FXML public void submitUserSignup(ActionEvent event) throws Exception {
		if(getID.getText().equals("") || getPW.getText().equals("") || getName.getText().equals("") || getPhoneNum.getText().equals("")) {
			Alert emptyError = new Alert(AlertType.ERROR);
			
			emptyError.setHeaderText("Empty Error");
			emptyError.setContentText("빈 칸을 채워주세요");
			emptyError.showAndWait();
		}
		else if(checkNum != 0) {
			Alert noCheckID = new Alert(AlertType.ERROR);
			noCheckID.setHeaderText("ID Check Error");
			noCheckID.setContentText("아이디 중복확인을 해주십시요.");
			noCheckID.showAndWait();
		}
		else if(!getPW.getText().equals(confirmPW.getText())) {
			Alert noCheckID = new Alert(AlertType.ERROR);
			noCheckID.setHeaderText("Check Password error");
			noCheckID.setContentText("재확인 비밀번호를 다시 입력해주세요.");
			noCheckID.showAndWait();
		}
		
		else {
		database.DBMembers.members_insert(getID.getText(), getPW.getText(), getName.getText(), getPhoneNum.getText());
		
		Stage primaryStage = new Stage();
		Stage stage = (Stage)submitBtn.getScene().getWindow();

			Parent asd = FXMLLoader.load(getClass().getResource("templates/login.fxml"));
			asd.getStylesheets().add(getClass().getResource("statics/login.css").toExternalForm());
			Scene sc = new Scene(asd);
			 primaryStage.setScene(sc);
	         primaryStage.show();
			 stage.close();
		}
	}

	
	//ID중복확인
	@FXML public void checkExistID() {
		checkNum = DBMembers.IDcheck(getID.getText());
		
		switch(checkNum) {
		case 0:
			Alert exist = new Alert(AlertType.INFORMATION);
			exist.setTitle("ID 중복 확인");
			exist.setHeaderText("존재하지 않는 아이디 입니다.");
			exist.setContentText("양식 작성을 계속 진행하여 주십시요.");
			exist.showAndWait();
			break;
		case 1:
			Alert noExist = new Alert(AlertType.WARNING);
			noExist.setTitle("ID 중복 확인");
			noExist.setHeaderText("존재하는 아이디 입니다.");
			noExist.setContentText("다시 작성하여 주세요.");
			noExist.showAndWait();
			break;
		default:
			System.out.println("ID중복확인 DB오류�");
			break;
		}	
	}

	@FXML public void goUserSignUp() throws Exception{
		
		Stage primaryStage = new Stage();
			Parent signUp = FXMLLoader.load(getClass().getResource("templates/UserSignup.fxml"));
			signUp.getStylesheets().add(getClass().getResource("statics/UserSignup.css").toExternalForm());
			 primaryStage.setScene(new Scene(signUp));
	         primaryStage.show();
	         
	         Stage stage = (Stage)UserSignUp.getScene().getWindow();
	         stage.close();
	}


	@FXML public void goHome() throws Exception{
		Stage primaryStage = new Stage();
		Parent signUp = FXMLLoader.load(getClass().getResource("templates/first.fxml"));
		signUp.getStylesheets().add(getClass().getResource("statics/first.css").toExternalForm());
		primaryStage.setScene(new Scene(signUp));
         primaryStage.show();
         
         Stage stage = (Stage)home.getScene().getWindow();
         stage.close();
	}

}
