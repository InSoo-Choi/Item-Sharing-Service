package user;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class postController {

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

}
