package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DBItems {
	
	public static ObservableList loadItems() {
		
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        ObservableList<ObservableList> ItemList = FXCollections.observableArrayList();
        
        try {
        	conn = DBconnect.connect();
        	stmt = conn.createStatement();
        	 
        	String sql = "SELECT post_num, post_name, kinds, post_by_id, limit_date From items";
        	rs = stmt.executeQuery(sql);
        	
        	while(rs.next()) {
        		ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                ItemList.add(row);
        	}
        	
        } catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( stmt != null && stmt.isClosed()){
                    stmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
        
        return ItemList;
	}
	
	public static ObservableList<String> loadOnePost(String post_num) {
		
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        ObservableList<String> itemRow = FXCollections.observableArrayList();
        
        try {
        	conn = DBconnect.connect();
        	stmt = conn.createStatement();
        	 
        	String sql = "SELECT post_name, kinds, post_by_id, limit_date, pub_date, price, content  From items WHERE post_num ="+post_num;
        	rs = stmt.executeQuery(sql);
        	while(rs.next()) {
        		for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    itemRow.add(rs.getString(i));
                }
        	}
        	
        } catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( stmt != null && stmt.isClosed()){
                    stmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
        
        return itemRow;
	}
}
