package home;


import java.io.IOException;
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
	@FXML Button managerOK;
	@FXML Label ManagerLogin;
	@FXML Label UserSignupLabel;
	

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
			second.getStylesheets().add(getClass().getResource("statics/managerLogin.css").toExternalForm());
			Scene sc = new Scene(second);
			primaryStage.setScene(sc);
	         primaryStage.show();
			 stage.close();
	}
	
	
	@FXML public void UserLogin(ActionEvent event) throws Exception {
		
		String PWfromDB = database.DBMembers.members_load(inputID.getText());

		MyInfo.setID(inputID.getText());
		
		if(inputPW.getText().equals("")) {
			Alert loginFail = new Alert(AlertType.ERROR);
			loginFail.setHeaderText("Empty error");
			loginFail.setContentText("아이디 또는 비밀번호를 입력해주세요");
			loginFail.showAndWait();
		}
		else if(PWfromDB.equals(inputPW.getText())) {
				
			System.out.println("login success");
			Stage primaryStage = new Stage();
			Stage stage = (Stage)loginOK.getScene().getWindow();
			
				Parent UserPage = FXMLLoader.load(getClass().getResource("/user/templates/userMain.fxml"));
				Scene sc = new Scene(UserPage);
				 primaryStage.setScene(sc);
		         primaryStage.show();
				 stage.close();
		}
		else {
		Alert loginFail = new Alert(AlertType.ERROR);
		loginFail.setHeaderText("Login Fail");
		loginFail.setContentText("�븘�씠�뵒 �삉�뒗 鍮꾨�踰덊샇瑜� �떎�떆 �솗�씤�빐二쇱꽭�슂.");
		loginFail.showAndWait();
		}
	}
	
	@FXML public void ManagerLogin(ActionEvent event) throws Exception {
		
		String PWfromDB = database.DBManagers.managers_load(inputManagerID.getText());
		
		if(inputManagerPW.getText().equals("")) {
			Alert loginFail = new Alert(AlertType.ERROR);
			loginFail.setHeaderText("Login Fail");
			loginFail.setContentText("아이디 또는 비밀번호를 입력해주세요.");
			loginFail.showAndWait();
		}
		else if(PWfromDB.equals(inputManagerPW.getText())) {
			System.out.println("login success");
			Stage primaryStage = new Stage();
			Stage stage = (Stage)managerOK.getScene().getWindow();
				Parent UserPage = FXMLLoader.load(getClass().getResource("/manager/templates/managerMain.fxml"));
				//UserPage.getStylesheets().add(getClass().getResource("statics/managerMain.css").toExternalForm());
				Scene sc = new Scene(UserPage);
				 primaryStage.setScene(sc);
		         primaryStage.show();
				 stage.close();
		}
		else {
		Alert loginFail = new Alert(AlertType.ERROR);
		loginFail.setHeaderText("Login Fail");
		loginFail.setContentText("�븘�씠�뵒 �삉�뒗 鍮꾨�踰덊샇瑜� �떎�떆 �솗�씤�빐二쇱꽭�슂.");
		loginFail.showAndWait();
		}
		
	}

	
	//�쉶�썝媛��엯
	@FXML public void submitUserSignup(ActionEvent event) throws Exception {
		if(getID.getText().equals("") || getPW.getText().equals("") || getName.getText().equals("") || getPhoneNum.getText().equals("")) {
			Alert emptyError = new Alert(AlertType.ERROR);
			
			emptyError.setHeaderText("Empty Error");
			emptyError.setContentText("鍮� 移몄쓣 梨꾩썙二쇱꽭�슂");
			emptyError.showAndWait();
		}
		else if(checkNum != 0) {
			Alert noCheckID = new Alert(AlertType.ERROR);
			noCheckID.setHeaderText("ID Check Error");
			noCheckID.setContentText("�븘�씠�뵒 以묐났�솗�씤�쓣 �빐二쇱떗�떆�슂.");
			noCheckID.showAndWait();
		}
		else if(!getPW.getText().equals(confirmPW.getText())) {
			Alert noCheckID = new Alert(AlertType.ERROR);
			noCheckID.setHeaderText("Check Password error");
			noCheckID.setContentText("�옱�솗�씤 鍮꾨�踰덊샇瑜� �떎�떆 �엯�젰�빐二쇱꽭�슂.");
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

	
	//ID以묐났�솗�씤
	@FXML public void checkExistID() {
		checkNum = DBMembers.IDcheck(getID.getText());
		
		switch(checkNum) {
		case 0:
			Alert exist = new Alert(AlertType.INFORMATION);
			exist.setTitle("ID 以묐났 �솗�씤");
			exist.setHeaderText("議댁옱�븯吏� �븡�뒗 �븘�씠�뵒 �엯�땲�떎.");
			exist.setContentText("�뼇�떇 �옉�꽦�쓣 怨꾩냽 吏꾪뻾�븯�뿬 二쇱떗�떆�슂.");
			exist.showAndWait();
			break;
		case 1:
			Alert noExist = new Alert(AlertType.WARNING);
			noExist.setTitle("ID 以묐났 �솗�씤");
			noExist.setHeaderText("議댁옱�븯�뒗 �븘�씠�뵒 �엯�땲�떎.");
			noExist.setContentText("�떎�떆 �옉�꽦�븯�뿬 二쇱꽭�슂.");
			noExist.showAndWait();
			break;
		default:
			System.out.println("ID以묐났�솗�씤 DB�삤瑜섓옙");
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


	@FXML public void toHome() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)UserLogin.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/first.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/first.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}


	@FXML public void toHome2() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)ManagerLogin.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/first.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/first.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}


	@FXML public void toHome3() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)UserSignupLabel.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/first.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/first.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}


}
