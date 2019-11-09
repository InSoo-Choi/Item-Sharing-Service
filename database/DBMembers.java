package database;
import java.sql.*;

public class DBMembers {

	//id를 인자로 받아 pw 불러오기 메소드 테스트 성공
	public static String members_load(String id) {
		
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String password = "";
        
        try {
        	conn = DBconnect.connect("Members");
        	 stmt = conn.createStatement();
        	 
        	String sql = "SELECT password From basicinfo WHERE id = "+"'"+id+"'";
        	rs = stmt.executeQuery(sql);
        	
        	while(rs.next()) {
        	password = rs.getString(1);
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
        return password;
	}
	
	
	
	// 회원가입 메소드 test성공
	public static void members_insert(String id, String password, String name, String phone) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBconnect.connect("Members");
			
			String sql = "INSERT INTO basicinfo VALUES (?,?,?,?)";
			 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.executeUpdate();
			System.out.println("Success");
			
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
}
