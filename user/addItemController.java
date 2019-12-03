package user;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import database.DBItems;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class addItemController implements Initializable {

	@FXML TextArea contents;
	@FXML Button moveMypage_Btn;
	@FXML TextField price;
	@FXML DatePicker limit_date;
	@FXML ComboBox<String> kinds;
	@FXML TextField post_title;
	@FXML Label aiMoveUserHome;
	@FXML HBox aiBtnColor;
	@FXML Button aiBtn1;
	@FXML Button aiBtn2;
	@FXML Button aiBtn3;
	@FXML Button aiBtn4;
	@FXML Button aiBtn5;
	@FXML Button aiBtn6;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> kindsList = FXCollections.observableArrayList("湲곕궡�슜�뭹","罹먮━�뼱", "移대찓�씪 �옣鍮�", "�깮�븘�뭹", "湲고�");
		kinds.setItems(kindsList);
	}

	@FXML public void postSubmit(ActionEvent event) throws Exception {
		
		LocalDate localDate = limit_date.getValue();
		
		String name = post_title.getText();
		String kind = kinds.getValue();
		String date = localDate.toString();
		String perDayPrice = price.getText();
		String content = contents.getText();
		String postByID = home.MyInfo.my_id;
		
		if(name == null || kind == null || date == null || perDayPrice == null || content == null) {
			Alert emptyError = new Alert(AlertType.ERROR);
			emptyError.setHeaderText("Empty error");
			emptyError.setContentText("�옉�꽦�릺吏��븡�� �빆紐⑹씠 �엳�뒿�땲�떎. �떎�떆 �솗�씤�빐二쇱꽭�슂.");
			emptyError.showAndWait();
		}
		else {
			DBItems.add(name, kind, postByID, content, perDayPrice, date);
			
			Alert addNotification = new Alert(AlertType.CONFIRMATION);
			addNotification.setHeaderText("Success");
			addNotification.setContentText("寃뚯떆湲� �벑濡앹씠 �셿猷뚮릺�뿀�뒿�땲�떎.");
			addNotification.showAndWait();
			
			Stage primaryStage = new Stage();
			Stage stage = (Stage)post_title.getScene().getWindow();

				Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
				ob.getStylesheets().add(getClass().getResource("statics/userMain.css").toExternalForm());
				Scene sc = new Scene(ob);
				primaryStage.setScene(sc);
		        primaryStage.show();
				stage.close();
		}
	}

	@FXML public void moveUserHome() throws Exception {
		
		Stage primaryStage = new Stage();
		Stage stage = (Stage)post_title.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/userMain.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}
}
