package com.alacriti.qA.service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alacriti.qA.bo.QandABO;
import com.alacriti.qA.vo.ProfileVo;

@Service
public class QandAService {
	@Autowired
	QandABO qAndABO;



	

	

	public ProfileVo getProfile(String authToken) {
		System.out.println("getEmailFromGoogle(String)");
		ProfileVo profile = null;
		
		boolean returnValidity = false;
		

System.out.println(" value for auth token to be sent: " + value);
		String url = "<your url>";
		try {
			
			//Parvez find the email profile from google---- get this code from net and implement
			
			System.out.println(" return validirty of email : " + returnValidity);
		} catch (Exception e) {
			System.out.println("exception in authorization");
			e.printStackTrace();
		} finally {
			return profile;

		}

	}

	public String setDecision(ProfileVo profileExtracted, String decision) {
		// TODO Auto-generated method stub
		return qAndABO.setDecision(profileExtracted,decision);
	}

}
