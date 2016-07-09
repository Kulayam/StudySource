package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import common.SqlCommon;
import dto.MemberDTO;

public class MemberDAO {
	
	SqlCommon sqlCommon;
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	public MemberDAO() {
		super();
		sqlCommon = SqlCommon.getInstance();
	}
	
	public ArrayList<MemberDTO> getMembers(HttpServletRequest req){
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = " select * from member ";
		try {
			rs = sqlCommon.getSelectResultSet(req,sql);
			while(rs.next()) list.add(new MemberDTO(rs.getString(1), rs.getString(2)));
		} catch (Exception e) {e.printStackTrace();}
		finally{sqlCommon.close(rs);}
		return list;
	}
}
