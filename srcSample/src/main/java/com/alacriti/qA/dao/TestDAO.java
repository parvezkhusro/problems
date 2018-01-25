package com.alacriti.qA.dao;

import java.sql.Connection;

import org.springframework.stereotype.Service;

@Service
public class TestDAO 
{
	
	public Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
	public String getBook(String id)
	{
		//Statement st = getConnection().prepareStatement("sele");
		System.out.println("Connection "+getConnection());
		
		return "book "+id;
	}
	

}
