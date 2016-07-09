package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dto.MemberDTO;

public class SqlLibrary {
	public static SqlLibrary sl = new SqlLibrary();
	SqlCommon common;
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	private SqlLibrary(){
		this.common = SqlCommon.getInstance();
		
	}
	
	/*public String getPassword(HttpServletRequest req, String pw){
		String password = "";
		conn = common.getConnection(req);
		try {
			psmt = conn.prepareStatement("select password('" + pw + "') as pass");
			rs = psmt.executeQuery();
			rs.next();
			password = rs.getString("pass");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			common.close(psmt, rs);
		}
		return password;
	}
	
	public static SqlLibrary getInstance(){
		return sl;
	}
	
	public boolean isMember(){
		
		return false;
	}
	
	public boolean loginCheck(HttpServletRequest req, String id, String pw){
		String getPw = getPassword(req,pw);
		String sql = "select * from member where id = ? and pw = ?";
		boolean isBool = false;
		try {
			conn = common.getConnection(req);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, getPw);
			rs = psmt.executeQuery();
			rs.next();
			String oriPw = rs.getString("pw");
			if(oriPw.equals(getPw)){
				req.getSession().setAttribute("member", new MemberDTO(rs.getString("id"), ""));
				isBool = true;
			}
		} catch (SQLException e) {}finally{
			common.close(psmt, rs);
		}
		return isBool;
	}
	*/
}
