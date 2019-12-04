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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class UserMainController implements Initializable {
	
	
	@FXML ComboBox<String> kinds;
	@FXML TableView itemListTable;
	@FXML TableColumn nameCol;
	@FXML TableColumn idCol;
	@FXML TableColumn limitCol;
	@FXML TableColumn priceCol;
	@FXML TableColumn likeCol;
	
	ObservableList itemList = database.DBItems.loadItems();
	@FXML Button umbtn1;
	@FXML Button umbtn2;
	@FXML Button umbtn3;
	@FXML Button umbtn4;
	@FXML Button umbtn5;
	@FXML Button umbtn6;
	@FXML HBox umtopHbox;
	@FXML Label umMoveUserHome;
	@FXML Label umTotal;
	@FXML Button umAddBtn;
	@FXML Button umMoveMypage_Btn;
	@FXML HBox umBtnColor;
	@FXML AnchorPane umBackColor;
	@FXML Label umTotalLabel;
	@FXML Label numTotal;
	
	Socket socket;

	@FXML public void moveMyPage() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)umMoveMypage_Btn.getScene().getWindow();
			Parent ob = FXMLLoader.load(getClass().getResource("templates/myPage.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/myPage.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
}
	@FXML public void moveAdd() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)umMoveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/addItem.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/addItem.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}
	
	@FXML public void umMoveLike() throws Exception {
		Stage primaryStage = new Stage();
		Stage stage = (Stage)umMoveMypage_Btn.getScene().getWindow();

			Parent ob = FXMLLoader.load(getClass().getResource("templates/like.fxml"));
			ob.getStylesheets().add(getClass().getResource("statics/like.css").toExternalForm());
			Scene sc = new Scene(ob);
			primaryStage.setScene(sc);
	        primaryStage.show();
			stage.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources){
		socket = MyInfo.socket;
		
		String cnt = null;
        try {
           String m = "itemsCnt:";
           BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
           PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
           
           pw.println(m);
           pw.flush();
           
          cnt = br.readLine();
          
          numTotal.setText(cnt);
          
        } catch (IOException e1) {
           e1.printStackTrace();
        }
		
		itemListTable.setItems(itemList);
		
		nameCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
            public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(1).toString());                        
            }                    
        });
		
		idCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
            public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(3).toString());                        
            }                    
        });
		
		limitCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
            public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(4).toString());                        
            }
        });
		
		priceCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
            public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(5).toString());                        
            }
        });
		
		likeCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
            public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(6).toString());                        
            }
        });
		
		
		itemListTable.setOnMousePressed(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle	(MouseEvent event) {
		        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
		            try {
		            	String[] rowData = itemListTable.getSelectionModel().getSelectedItem().toString().split(",");
		            	MyInfo.setOnePostNum(rowData[0].substring(1));
		            	
						moveShowOne();
					} catch (Exception e) {
						e.printStackTrace();
					}
		        }
		    }
		});
	}
	
	public void moveShowOne() throws Exception {
		
        Stage primaryStage = new Stage();
		Stage stage = (Stage)umMoveMypage_Btn.getScene().getWindow();
		Parent ob = FXMLLoader.load(getClass().getResource("templates/showOnePost.fxml"));
		ob.getStylesheets().add(getClass().getResource("statics/showOnePost.css").toExternalForm());
		Scene sc = new Scene(ob);
		primaryStage.setScene(sc);
        primaryStage.show();
		stage.close();
	}


}
