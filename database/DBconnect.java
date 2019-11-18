package database;
import java.sql.*;

public class DBconnect {

	 public static Connection connect() {
		 	String usr = "#";
		 	String password = "#";
            String url = "jdbc:mysql://59.27.140.107:3306/h5seung?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";

	        Connection conn = null;

	        try{
	           Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(url, "h5seung", password);
	            System.out.println("연결 성공");

	        }
	        catch(ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch(SQLException e){
	        	e.printStackTrace();
	        }
	        
	        return conn;
	        
	    }
}