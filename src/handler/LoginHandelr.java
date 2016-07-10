package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import service.Service;

public class LoginHandelr implements Service{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		boolean isMember = MemberDAO.getInstance().login(req.getParameter("id"), req.getParameter("pw"));
		if(isMember) {
			req.getSession().setAttribute("memberID", req.getParameter("id"));
			return "LoginOk.jsp";
		}
		return "LoginFail.jsp";
	}

}
