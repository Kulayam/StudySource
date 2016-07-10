package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);
		boolean isLogin = false;
		if(session != null){
			if(session.getAttribute("memberID") != null){
				isLogin = true;
			}
		}
		if(isLogin){
			chain.doFilter(req, res);
		}else{
			request.getRequestDispatcher("/Login.jsp").forward(req, res);
		}
	}

	@Override
	public void destroy() {
		
	}
}
