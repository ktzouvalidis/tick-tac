package com.ticktac.data;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAOFactory {
	public DAOFactory() {}
	
	/*
	 * <p> Attempts to get the connection via a Data Source.
	 * @return The connection
	 */
	public static Connection getConnection() {
		try {
			Context context = new InitialContext();
			return ((DataSource)context.lookup("java:comp/env/jdbc/DSName")).getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public UserDAO getUserDAO() {
		return new UserDAO();
	}
}
