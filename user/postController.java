package user;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

import home.MyInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class postController implements Initializable {

	@FXML Button showonepostmoveMypage_Btn;
	@FXML HBox sopTopHbox;
	@FXML HBox sopBtnColor;
	@FXML Button sopBtn1;
	@FXML Button sopBtn2;
	@FXML Button sopBtn3;
	@FXML Button sopBtn4;
	@FXML Button sopBtn5;
	@FXML Button sopBtn6;
	@FXML Button sopAddBtn;
	@FXML Label postName;
	@FXML Label contentArea;
	@FXML Label idOutput;
	@FXML Label sopTitle;
	@FXML Label sopCategory;
	@FXML Label sopWriterID;
	@FXML Label sopLab1;
	@FXML Label sopLab2;
	@FXML Label sopLab3;
	@FXML Label sopDate1;
	@FXML Label sopDate2;
	@FXML Label sopMoney;
	@FXML Button sopLikeBtn;
	@FXML Button sopMoveUserHomeBtn;
	@FXML Button sopRentBtn;

	Socket socket;
	@FXML AnchorPane sopBackColor;
	@FXML Button sopNoticeBtn;
	
	@FXML public void showonepostmoveMyPage() throws Exception{
		 	Stage primaryStage = new Stage();
			Stage stage = (Stage)sopTitle.getScene().getWindow();
			Parent ob = FXMLLoader.load(getClass().getResource("templates/myPage.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/myPage.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@FXML public void sopMoveUserHome() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)sopTitle.getScene().getWindow();
		Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
		ob.getStylesheets().add(getClass().getResource("statics/userMain.css").toExternalForm());
		Scene sc = new Scene(ob);
		primaryStage.setScene(sc);
        primaryStage.show();
		stage.close();
	}

	@FXML public void moveUserHome() throws Exception{
		Stage primaryStage = new Stage();
		Stage stage = (Stage)sopTitle.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/userMain.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/userMain.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		socket = MyInfo.socket;
		
		String[] oneData = null;
        try {
           String m = "loadOnePost:" + MyInfo.onePostNum;
           BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
           PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
           pw.println(m);
           pw.flush();
           
           oneData = br.readLine().split(":", 7);
           postName.setText(oneData[0]);
           sopCategory.setText(oneData[1]);
           idOutput.setText(oneData[2]);
           sopDate2.setText(oneData[3]);
           sopDate1.setText(oneData[4]);
           sopMoney.setText(oneData[5]);
           contentArea.setText(oneData[6]);
          
        } catch (IOException e1) {
           e1.printStackTrace();
        }
		
		
	}

}
