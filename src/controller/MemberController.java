package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/Members")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		action(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		action(req, res);
	}
	
	private void action(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("action");
		req.setCharacterEncoding("UTF-8");
		//sv.execute(req, res);
		req.getRequestDispatcher("MemberCheck.jsp").forward(req, res);
	}
}
