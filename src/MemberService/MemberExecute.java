package MemberService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;
import service.ActionService;

public class MemberExecute implements ActionService{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list = new MemberDAO().getMembers(req);
		req.setAttribute("members", list);
	}

	
}
