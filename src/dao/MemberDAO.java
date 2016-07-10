package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import service.Work;

import common.CommonUtil;
import common.JDBCUtil;

import dto.MemberDTO;

public class MemberDAO {
	JDBCUtil ju = null;
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	public static MemberDAO memberDAO = new MemberDAO();
	public static MemberDAO getInstance(){
		return memberDAO;
	}
	private MemberDAO() {
		super();
		ju = JDBCUtil.getInstance();
	}
	
	public boolean login(String id, String pw){
		String getPw = CommonUtil.getInstance().getPassword(pw);
		String[] memberInfo = {id, getPw};
		String query = "select * from member where id = ? and pw = ?";
		boolean isMember = false;
		Object obj = null;
		obj = ju.getObjectExecuteQuery(new Work() {
			public ArrayList<Object> execute(ArrayList<Object> list, ResultSet rs)
					throws SQLException {
				if(rs.next()) list.add(new MemberDTO(rs.getString(2), rs.getString(3)));
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
