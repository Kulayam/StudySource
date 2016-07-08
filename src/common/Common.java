package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class Common {
	public static Common common = new Common();
	Connection conn;
	private Common(){
		
	}
	
	public Connection getConnection(HttpServletRequest req){
		String url = req.getServletContext().getInitParameter("mysql_url");
		String user = req.getServletContext().getInitParameter("mysql_id");
		String password = req.getServletContext().getInitParameter("mysql_pw");
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn 완료");
		} catch (SQLException e) {
			System.out.println("에러");
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(PreparedStatement psmt, ResultSet rs){
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {}
		
	}
	
	public static Common getInstance(){
		return common;
	}
}
