package com.alacriti.qA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.qA.service.QandAService;
import com.alacriti.qA.vo.DecisionVo;
import com.alacriti.qA.vo.ProfileVo;

@RestController
@RequestMapping("/qAndAContoller")
public class QandAController {

	@Autowired
	QandAService qAndAService;
	
	//test method
	@RequestMapping(method=RequestMethod.GET, value="/{authToken}")
	public String test(@PathVariable String auth) {
		System.out.println("hit");
	System.out.println("auth--- "+auth);
		
		return "auth---------"+auth;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/decision")
	public String getDecision(@RequestBody DecisionVo decisionVo) {
		System.out.println("com.alacriti.qA.controller.QandAController.getDecision(DecisionVo)");
		System.out.println("Access Token====>"+decisionVo.getAccessToken());
		
		String decision=decisionVo.getDecision().trim();
		String message=null;
		System.out.println(" decision : "+decision);
		if(!decision.equals("Y") && !decision.equals("N"))
			return "Please send a valid value";
		else{
			ProfileVo profileExtracted= qAndAService.getProfile(decisionVo.getAccessToken());
			System.out.println(" email exists -- " + profileExtracted.getEmail());
			message=qAndAService.setDecision(profileExtracted,decision);
			return message;
			
		}
		
	}
	
	
}
