package com.alacriti.qA.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.AALOAD;

@Service
public class QandADAO extends BaseDAO {

	



	
	private int getID(String email) {
		System.out.println("com.alacriti.qA.dao.QandADAO.getID(String)");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		String cmd = "select id from tbl where email=?";

		try {
			System.out.println("cmd " + email);
			ps = connection.prepareStatement(cmd);

			ps.setString(1, email);

			rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
				System.out.println("id =" + id);
			}

		} catch (SQLException e) {
			System.out.println("DAO issue in get id--- " + e);
			e.printStackTrace();
		} finally {
			System.out.println("returning id= " + id);
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return id;

		}

	}

	



	public String setSurveyInDB(String email, String decision) {
		// TODO Auto-generated method stub
		
		System.out.println("com.alacriti.qA.dao.QandADAO.setSurveyInDB(String, String)");
		
		int id;

		System.out.println("Connection " + getConnection());
		
		id = getID(email);
		System.out.println("id ---- "+id +"---- email  : "+email+" decision=== "+decision);
		
		boolean updateDecision=updateDecisionInDB(id,decision) ;
		
		if(updateDecision==false){
			System.out.println("updateDecision-- "+updateDecision);
			return "Sorry, couldn't save your resp. please try again";
		}
		else{
			System.out.println("updateDecision-- "+updateDecision);
			return "Thank you for your response.";
		}
	}



	private boolean updateDecisionInDB(int id, String decision) {
		// TODO Auto-generated method stub
		System.out.println("com.alacriti.qA.dao.QandADAO.updateDecisionInDB(int, String)");
		PreparedStatement ps = null;
		int result = -1;
		boolean allOK=true;
		String cmd = "update tbl set decision = ?, last_modified_time = now() where id=?";

		try {
			System.out.println("cmd " + decision+".... "+id);
			ps = connection.prepareStatement(cmd);

			ps.setString(1, decision);
			ps.setInt(2, id);

			result = ps.executeUpdate();
			System.out.println("updated desision ----" + result);

		} catch (SQLException e) {
			allOK=false;
			System.out.println("DAO issue update decision--- " + e);
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				
				if(allOK==true){
					connection.commit();
					return true;
				}
				else{
					connection.rollback();
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				allOK=false;
				e.printStackTrace();
				return false;
			}
			

		}
	}




	public boolean alreadyCompletedSurvey(String email) {
		// TODO Auto-generated method stub
		
		System.out.println("com.alacriti.qA.dao.QandADAO.checkIfAlreadyFound(String)");
		String command = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String decision = null;
		
		
		System.out.println("Connection " + getConnection());
		System.out.println("email id " + getConnection());
		
		command="select decision from tbl where email=?";
		
		try {
			System.out.println("cmd " + command);
			ps = connection.prepareStatement(command);

			ps.setString(1, email);

			rs = ps.executeQuery();
			if (rs.next()) {
				decision = rs.getString(1);
				System.out.println("decision--"+decision);
				System.out.println("email id--"+email);
			}

		} catch (SQLException e) {
			System.out.println("DAO issue --- " + e);
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (decision==null) {
					return false;
				} else {
				return true;
				}
			}
		}

	}

	
}
