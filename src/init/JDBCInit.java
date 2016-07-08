package init;


import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.PoolableConnection;
import org.apache.tomcat.dbcp.dbcp2.PoolableConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.PoolingDriver;
import org.apache.tomcat.dbcp.pool2.impl.GenericObjectPool;
import org.apache.tomcat.dbcp.pool2.impl.GenericObjectPoolConfig;

public class JDBCInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	String forName = config.getServletContext().getInitParameter("mysql_forname");
    	
    	try{
    		Class.forName(forName);
    		initConnectionPool(config);
    	}catch(Exception e){
    		throw new RuntimeException();
    	}
    }
    
    private void initConnectionPool(ServletConfig config){
    	System.out.println("1");
    	String url = config.getServletContext().getInitParameter("mysql_url");
		String user = config.getServletContext().getInitParameter("mysql_id");
		String password = config.getServletContext().getInitParameter("mysql_pw");
		try {
			System.out.println("2");
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(url, user, password);
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1");
			System.out.println("3");
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			poolConfig.setTestWhileIdle(true);
			poolConfig.setMinIdle(4);
			poolConfig.setMaxIdle(50);
			System.out.println("4");
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory,poolConfig);
			poolableConnFactory.setPool(connectionPool);
			System.out.println("5");
			Class.forName(config.getServletContext().getInitParameter("pool_driver"));
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver(config.getServletContext().getInitParameter("pool_dpcp"));
			System.out.println("6");
			driver.registerPool("JSPLibrary", connectionPool);
			System.out.println("7");
    }catch(Exception e){System.out.println(e.getMessage());}
		
    }
}
