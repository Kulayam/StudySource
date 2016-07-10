package service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException;
}
