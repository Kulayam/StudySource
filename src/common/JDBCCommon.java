package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.PoolableConnection;
import org.apache.tomcat.dbcp.dbcp2.PoolableConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.PoolingDriver;
import org.apache.tomcat.dbcp.pool2.impl.GenericObjectPool;
import org.apache.tomcat.dbcp.pool2.impl.GenericObjectPoolConfig;

public class JDBCCommon {
	public static JDBCCommon jdbcCommon = new JDBCCommon();
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;
	private JDBCCommon(){
		
	}
	
	public Connection getConnection(){
		Context init;
		try {
			init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/JSPLibrary");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public void close(ResultSet rs){
		try {
			if(rs != null) rs.close();
			if(this.psmt != null) psmt.close();
			if(this.conn != null) conn.close();
		} catch (Exception e) {}
		
	}
	
	public void close(PreparedStatement psmt){
		try {
			if(this.psmt != null) psmt.close();
			if(this.conn != null) conn.close();
		} catch (Exception e) {}
		
	}
	
	public void close(PreparedStatement psmt, ResultSet rs){
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {}
		
	}
	
	public static JDBCCommon getInstance(){
		return jdbcCommon;
	}
	
	
}
