package manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.ResourceBundle;

import home.MyInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;

public class managerController implements Initializable{
	
	ObservableList<ObservableList> mylist = FXCollections.observableArrayList();
	
	Socket socket;
	@FXML TableColumn nCol;
	@FXML Button mmNoticeBtn;

	@FXML AnchorPane mmBackColor;

	@FXML HBox mmtopHbox;

	@FXML Label mmMoveUserHome;

	@FXML HBox umBtnColor;

	@FXML Button mmbtn1;

	@FXML Button mmbtn2;

	@FXML Button mmbtn3;

	@FXML Button mmbtn4;

	@FXML Button mmbtn5;

	@FXML Button mmbtn6;

	@FXML Label mmTotalLabel;

	@FXML Label mmNumTotal;

	@FXML TableView<ObservableList> mmItemListTable;

	@FXML TableColumn mmNameCol;

	@FXML TableColumn mmIdCol;

	@FXML TableColumn mmPriceCol;

	@FXML Button umMoveMypage_Btn;

	@FXML Button mmEraseBtn;

	@FXML Label managerTitle;
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		socket = MyInfo.socket;
		
		String myList = null;
		String[] temp = null;
        try {
           String m = "loadItemList:";
           BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
           PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
           
           pw.println(m);
           pw.flush();
           
           myList = br.readLine();
           temp = myList.split("//");
           
           System.out.println(Arrays.deepToString(temp));
           
           if(Arrays.deepToString(temp).equals("[]")) {

        	   mmItemListTable.setItems(null);
        	   return;
           }
           
           for(int i = 0; i < temp.length; i++) {
        	   ObservableList<String> row = FXCollections.observableArrayList();
        	  
        	   String[] temp2 = temp[i].split("@@");
        	   		for(int j = 0; j<temp2.length; j++) {
        	   			row.add(temp2[j]);
        	   }
        	   	mylist.add(row);
           }
           
           mmItemListTable.setItems(mylist);
           
           nCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
               public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                   return new SimpleStringProperty(param.getValue().get(0).toString());                        
               }                    
           });
           
           mmNameCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
               public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                   return new SimpleStringProperty(param.getValue().get(1).toString());                        
               }                    
           });
   			
           mmIdCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
               public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                   return new SimpleStringProperty(param.getValue().get(3).toString());                        
               }                    
           });
           
           mmPriceCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
               public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                   return new SimpleStringProperty(param.getValue().get(5).toString());                        
               }                    
           });		
           
           
        } catch (IOException e1) {
        	e1.printStackTrace();
        }

	}

	@FXML public void managerErase() {
		socket = MyInfo.socket;
		String[] rowData = mmItemListTable.getSelectionModel().getSelectedItem().toString().split(",");
		try {
	           String m = "deleteData:"+rowData[0].substring(1);
	           PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
	           
	           pw.println(m);
	           pw.flush();
	           
		} catch (IOException e1) {
	        e1.printStackTrace();
	     }
		
	}
	
	

}
