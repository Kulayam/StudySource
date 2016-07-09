package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import service.Work;

public class JDBCUtil {
	public static JDBCUtil ju = new JDBCUtil();
	JDBCCommon common = null;
	Connection conn  = null;
	PreparedStatement psmt  = null;
	ResultSet rs  = null;
	private JDBCUtil(){
		this.common = JDBCCommon.getInstance();
	}
	
	public static JDBCUtil getJDBCUtil(){
		return ju;
	}
	
	public ArrayList<Object> getListExecute(Work work, String query, Object[] parameter){
		ArrayList<Object> list = new ArrayList<Object>();
		try{
			this.rs = getResultSetExecuteQuery(query, parameter);
			list = work.execuete(list, this.rs);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			common.close(this.psmt, this.rs);
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
			list = work.execuete(list, this.rs);
			if(!list.isEmpty()) obj = list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			common.close(this.psmt, this.rs);
		}
		return obj;
	}
	
	public Object getObjectExecuteQuery(Work work, String query, Object parameter){
		Object obj = null;
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			this.rs = getResultSetExecuteQuery(query, parameter);
			list = work.execuete(list, this.rs);
			if(!list.isEmpty()) obj = list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			common.close(this.psmt, this.rs);
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
		this.conn = common.getConnection();
		this.psmt = this.conn.prepareStatement(query);
		if(parameter != null)
		for(int i = 0; i < parameter.length; i++){
			if(parameter[i] instanceof String) this.psmt.setString(i+1, (String) parameter[i]);
			else if(parameter[i] instanceof Integer) this.psmt.setInt(i+1, (int) parameter[i]);
		}
		return this.psmt;
	}
	
	public PreparedStatement setQuery(String query, Object parameter) throws SQLException{
		this.conn = common.getConnection();
		this.psmt = this.conn.prepareStatement(query);
		if(parameter != null)
			if(parameter instanceof String) this.psmt.setString(1, (String) parameter);
			else if(parameter instanceof Integer) this.psmt.setInt(1, (int) parameter);
		return this.psmt;
	}
}
