package init;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class JDBCInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	String forName = config.getServletContext().getInitParameter("mysql_forname");
    	log(forName);
    	try{
    		Class.forName(forName);
    	}catch(Exception e){
    		throw new RuntimeException();
    	}
    }

}
