package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Work {
	public ArrayList<Object> execute(ArrayList<Object> list, ResultSet rs) throws SQLException;
}
