package com.alacriti.qA.bo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alacriti.qA.dao.QandADAO;
import com.alacriti.qA.resource.Resource;
import com.alacriti.qA.vo.ProfileVo;

@Service
public class QandABO extends BaseBO {

	@Autowired
	Resource resource;

	@Autowired
	QandADAO qAndADAO;

	

	
	
	private boolean alreadyCompletedSurvey(String email) {
		System.out.println("com.alacriti.empport.bo.SecretBO.alreadyFoundFriend(String)");
		boolean completedSurvey = false;
		completedSurvey = qAndADAO.alreadyCompletedSurvey(email);
		System.out.println("completed ----" + completedSurvey);
			return completedSurvey;
		
	}

	



	public String setDecision(ProfileVo profile, String decision) {
		// TODO Auto-generated method stub
		System.out.println("com.alacriti.qA.bo.QandABO.setDecision(ProfileVo, String)");
		connection = resource.getConnection();
		qAndADAO.setConnection(connection);
		System.out.println("connection : -----"+ connection);
		String resultMessage = setSurveyDetails(profile.getEmail(),decision);
	return resultMessage;
	}
	
	private String setSurveyDetails(String email,String decision) {
		System.out.println("com.alacriti.qA.bo.QandABO.setSurveyDetails(String)");
		boolean surveyTaken = false;
		surveyTaken = alreadyCompletedSurvey(email);
		System.out.println(" survey taken ========" + surveyTaken);

		if (surveyTaken ==true) {
			return "Survey already completed";
		} else {
			return setSurveyInDB(email,decision);
		}

	}
	private String setSurveyInDB(String email,String decision) {

		String surveySaved = qAndADAO.setSurveyInDB(email,decision);
		System.out.println("Data saved --" + surveySaved);
		return surveySaved;

	}

}
