package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBtest {
	public static void main(String[] args) {
		System.out.println(IDcheck("test"));
	}
	public static String IDcheck(String id) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String suc = ""; // 1:중복 0:중복x
        
        try {
        	conn = DBconnect.connect();
        	 stmt = conn.createStatement();
        	 
        	String sql = "select EXISTS (select * from members where id='"+id+"') as success";
        	rs = stmt.executeQuery(sql);
        	
        	while(rs.next()) {
        	suc = rs.getString(1);
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
    return suc;
	}
}
