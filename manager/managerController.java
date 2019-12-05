package manager;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;

public class managerController {

	@FXML HBox mmTopHbox;
	@FXML Label mmMoveUserHome;
	@FXML HBox mmBtnColor;
	@FXML Button mmBtn1;
	@FXML Button mmBtn2;
	@FXML Button mmBtn3;
	@FXML Button mmBtn4;
	@FXML Button mmBtn5;
	@FXML Button mmBtn6;
	@FXML Label mmTotalLabel;
	@FXML Label mmTotal;
	@FXML Button mmEraseBtn;
	@FXML AnchorPane mmBackColor;
	@FXML TableView mmItemListTable;
	@FXML TableColumn nameCol;
	@FXML TableColumn idCol;
	@FXML TableColumn priceCol;
	
	ObservableList itemList = database.DBItems.loadItems();
	
	Socket socket;
	
	@SuppressWarnings("unchecked")
	public void initialize(URL location, ResourceBundle resources){
		socket = MyInfo.socket;
		
        try {
           String m = "itemsCnt:";
           BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
           PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
           
           pw.println(m);
           pw.flush();
           
          
        } catch (IOException e1) {
           e1.printStackTrace();
        }
		
        mmItemListTable.setItems(itemList);
		
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
		
		priceCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
            public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(5).toString());                        
            }
        });
		
		
		mmItemListTable.setOnMousePressed(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle	(MouseEvent event) {
		        
		    }
		});
	}

}
