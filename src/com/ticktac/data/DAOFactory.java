package com.ticktac.data;

import java.sql.Connection;
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
			return ((DataSource) new InitialContext().lookup("java:comp/env/jdbc/ticktac")).getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public UserDAO getUserDAO() {
		return new UserDAO();
	}
}
