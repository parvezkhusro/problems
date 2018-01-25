package com.alacriti.qA.resource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Resource 
{
	@Autowired
	DataSource dataSource;

	public Connection getConnection()
	{
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Exception while getting connection "+e);
			e.printStackTrace();
		}
		return null;
	}
}
