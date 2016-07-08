package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.Common;
import dto.MemberDTO;

public class MemberDAO {
	
	Common common;
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	public MemberDAO() {
		super();
		common = Common.getInstance();
	}
	
	public ArrayList<MemberDTO> getMembers(HttpServletRequest req){
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		conn = common.getConnection(req);
		String sql = " select * from member ";
		try{
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				list.add(new MemberDTO(rs.getString(2), rs.getString(3)));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			common.close(psmt, rs);
		}
		
		return list;
	}
}
