package com.alacriti.qA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.qA.service.TestService;

@RestController
@RequestMapping("/testbooks")
public class TestController 
{
	@Autowired
	TestService testService;
	
	@RequestMapping
	public String test() {
		return "all books";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public String getBook(@PathVariable String id)
	{
		return testService.getBook(id);
	}

}
