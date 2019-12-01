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

public class addItemController implements Initializable {

	@FXML TextArea contents;
	@FXML Button moveMypage_Btn;
	@FXML TextField price;
	@FXML DatePicker limit_date;
	@FXML ComboBox<String> kinds;
	@FXML TextField post_title;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> kindsList = FXCollections.observableArrayList("기내용품","캐리어", "카메라 장비", "생필품", "기타");
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
			emptyError.setContentText("작성되지않은 항목이 있습니다. 다시 확인해주세요.");
			emptyError.showAndWait();
		}
		else {
			DBItems.add(name, kind, postByID, content, perDayPrice, date);
			
			Alert addNotification = new Alert(AlertType.CONFIRMATION);
			addNotification.setHeaderText("Success");
			addNotification.setContentText("게시글 등록이 완료되었습니다.");
			addNotification.showAndWait();
			
			Stage primaryStage = new Stage();
			Stage stage = (Stage)post_title.getScene().getWindow();

				Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
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
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}
}
