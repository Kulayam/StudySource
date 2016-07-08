package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionService {
	public void execute(HttpServletRequest req, HttpServletResponse res);
}
