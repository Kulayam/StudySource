package common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import service.Work;

public class CommonUtil {

	public static CommonUtil commonUtil = new CommonUtil();
	JDBCUtil ju = null;
	public static CommonUtil getInstance(){
		return commonUtil;
	}
	private CommonUtil() {
		super();
		ju = JDBCUtil.getInstance();
	}
	
	public String getPassword(String pw){
		String password = (String) ju.getObjectExecuteQuery(new Work() {
			public ArrayList<Object> execute(ArrayList<Object> list, ResultSet rs) throws SQLException {
				if(rs.next()) list.add(rs.getString("pw"));
				return list;
			}
		}, "select password(?) as pw", pw);
		if(password != null) return password;
		return null;
	}
	
}
