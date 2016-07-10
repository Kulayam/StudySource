package controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import error.NotPage;

public class FrontContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Service> commandMap = null;   
    public FrontContoller() {
        super();
    }

	public void init() throws ServletException {
		commandMap = new HashMap<String, Service>(); 
		String configFile = getInitParameter("configFile"); //맵핑 시키기 위한 프로퍼티 파일 경로
		Properties prop = new Properties(); // 프로퍼티 생성
		String configFilePath = getServletContext().getRealPath(configFile); // 실제 프로퍼티 파일 경로를 반환
		try(FileReader read = new FileReader(configFilePath)){ //파일 리더에 프로퍼티 파일을 읽어 드림
			prop.load(read); // 프로퍼티로 읽어 드림
		}catch(IOException io){throw new ServletException(io);}
		Iterator<Object> it = prop.keySet().iterator(); //이터레이터로 키 값을 뽑아내기 위함
		while(it.hasNext()){ 
			String commandKey = (String) it.next();// 키 값 불러옴
			String HandlerClassName = prop.getProperty(commandKey);// 키 = 값 을 불러옴
			try{
				Class<?> handlerClass = Class.forName(HandlerClassName); //키 값으로 불러온 클래스
				Service sv = (Service) handlerClass.newInstance();// 해당 클래스를 불러와 서비스 인터페이스에 담음
				commandMap.put(commandKey, sv); // 해당 클래스객체를 해쉬맵에 담음
			}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){throw new ServletException(e);}
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		action(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		action(req, res);
	}

	private void action(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		log(uri);
		if(uri.indexOf(req.getContextPath()) == 0) 
			uri = uri.substring(req.getContextPath().length());
		log(uri);
		Service sv = commandMap.get(uri);
		log("sv");
		if(sv == null) sv = new NotPage();
		String goToPage = null;
		try{
			goToPage = sv.execute(req, res);
			log(goToPage);
		}catch(Throwable e){
			throw new ServletException(e);
		}
		if(goToPage != null){
			req.getRequestDispatcher(goToPage).forward(req, res);
		}
	}

}
