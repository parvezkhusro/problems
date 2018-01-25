package com.alacriti.qA.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO 
{

	
	public Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("unable to set auto commit off");
			e.printStackTrace();
		}
	}
	
	public void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}
}
