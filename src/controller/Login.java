package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SqlLibrary;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*req.setCharacterEncoding("UTF-8");
		SqlLibrary sl = SqlLibrary.getInstance();
		System.out.println("id : " + req.getParameter("id"));
		if(sl.loginCheck(req, req.getParameter("id"), req.getParameter("pw"))){
			req.getRequestDispatcher("LoginOk.jsp").forward(req, res);
		}else{
			res.sendRedirect("LoginFail.jsp");
		}*/
	}

}
