package database;
import java.sql.*;

public class DBconnect {
	 public static Connection connect(String db_name) {
		 	String password = "dreamdev77HSO!";
		 	String url = "jdbc:mysql://localhost/"+db_name;

	        Connection conn = null;

	        try{
	           Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(url, "root", password);
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