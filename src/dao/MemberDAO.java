package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import service.Work;
import common.CommonUtil;
import common.JDBCCommon;
import common.JDBCUtil;
import dto.MemberDTO;

public class MemberDAO {
	JDBCUtil ju = null;
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	public MemberDAO() {
		super();
		ju = JDBCUtil.getJDBCUtil();
	}
	
	public boolean login(String id, String pw){
		String[] memberInfo = {id, pw};
		String getPw = CommonUtil.getCommonUtil().getPassword(pw);
		String query = "select * from member id = ? and pw = ?";
		boolean isMember = false;
		Object obj = null;
		obj = ju.getObjectExecuteQuery(new Work() {
			@Override
			public ArrayList<Object> execuete(ArrayList<Object> list, ResultSet rs)
					throws SQLException {
				if(rs.next()) list.add(new MemberDTO(rs.getString(1), rs.getString(2)));
				return list;
			}
		}, query, memberInfo);
		if(obj != null){
			MemberDTO member = (MemberDTO) obj;
			if(getPw.equals(member.getPw())){
				isMember = true;
			}
		}
		return isMember;
	}
}
