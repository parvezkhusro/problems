package com.alacriti.qA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alacriti.qA.dao.TestDAO;
import com.alacriti.qA.resource.Resource;

@Service
public class TestService
{
	@Autowired
	TestDAO testDAO;
	
	@Autowired
	Resource resource;
	
	public String getBook(String id)
	{
		testDAO.setConnection(resource.getConnection());
		testDAO.getBook(id);
		return "book "+id;
	}

}
