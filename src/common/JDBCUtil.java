package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import service.Work;

public class JDBCUtil {
	public static JDBCUtil ju = new JDBCUtil();
	Connection conn  = null;
	PreparedStatement psmt  = null;
	ResultSet rs  = null;
	private JDBCUtil(){
	}
	
	public static JDBCUtil getInstance(){
		return ju;
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
	
	public ArrayList<Object> getListExecute(Work work, String query, Object[] parameter){
		ArrayList<Object> list = new ArrayList<Object>();
		try{
			this.rs = getResultSetExecuteQuery(query, parameter);
			list = work.execute(list, this.rs);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(this.psmt, this.rs);
		}
		
		if(!list.isEmpty()){
			return list;
		}else{
			return null;
		}
	}
	
	public Object getObjectExecuteQuery(Work work, String query, Object[] parameter){
		Object obj = null;
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			this.rs = getResultSetExecuteQuery(query, parameter);
			list = work.execute(list, this.rs);
			if(!list.isEmpty()) obj = list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(this.psmt, this.rs);
		}
		return obj;
	}
	
	public Object getObjectExecuteQuery(Work work, String query, Object parameter){
		Object obj = null;
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			this.rs = getResultSetExecuteQuery(query, parameter);
			list = work.execute(list, this.rs);
			if(!list.isEmpty()) obj = list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(this.psmt, this.rs);
		}
		return obj;
	}
	
	
	public ResultSet getResultSetExecuteQuery(String query, Object[] parameter) throws SQLException{
		try{
			this.psmt = setQuery(query, parameter);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this.psmt.executeQuery();
	}
	
	public ResultSet getResultSetExecuteQuery(String query, Object parameter) throws SQLException{
		try{
			this.psmt = setQuery(query, parameter);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this.psmt.executeQuery();
	}
	
	public PreparedStatement setQuery(String query, Object[] parameter) throws SQLException{
		this.conn = getConnection();
		this.psmt = this.conn.prepareStatement(query);
		if(parameter != null)
		for(int i = 0; i < parameter.length; i++){
			if(parameter[i] instanceof String) this.psmt.setString(i+1, (String) parameter[i]);
			else if(parameter[i] instanceof Integer) this.psmt.setInt(i+1, (int) parameter[i]);
		}
		return this.psmt;
	}
	
	public PreparedStatement setQuery(String query, Object parameter) throws SQLException{
		this.conn = getConnection();
		this.psmt = this.conn.prepareStatement(query);
		if(parameter != null)
			if(parameter instanceof String) this.psmt.setString(1, (String) parameter);
			else if(parameter instanceof Integer) this.psmt.setInt(1, (int) parameter);
		return this.psmt;
	}
}
