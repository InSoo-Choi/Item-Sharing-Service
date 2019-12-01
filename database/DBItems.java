package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBItems {
	
	public static void add(String name, String kind, String postByID, String content, String price, String limit_date) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnect.connect();
			
			String sql = "INSERT INTO items VALUES (null,?,?,?,?,?,?,?,?,?,?,?)";
			
			long time = System.currentTimeMillis(); 

			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String pub_time = dayTime.format(new Date(time));
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, kind);
			pstmt.setString(3, postByID);
			pstmt.setString(4, "0");
			pstmt.setString(5, "null");
			pstmt.setString(6, "null");
			pstmt.setString(7, content);
			pstmt.setString(8, price);
			pstmt.setString(9, limit_date);
			pstmt.setString(10, "0");
			pstmt.setString(11, pub_time); //pub_date
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
		
	}
	
	public static void loadItems() {
		
	}
}
