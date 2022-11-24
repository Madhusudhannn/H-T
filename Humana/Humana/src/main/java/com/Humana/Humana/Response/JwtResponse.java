package com.Humana.Humana.Response;

import java.time.LocalDate;
import java.util.List;

public class JwtResponse {
	private String token; 
	private String type = "Bearer";  
	private Integer userid;
	private String firstName;
	private String lastName;
	private String emailID;
	private LocalDate dob;
	private String roles;

	public JwtResponse(String accessToken, Integer userid,String firstName,String lastName,LocalDate dob, String emailID, String roles) {
		this.token = accessToken;
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.dob=dob;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}
    
	
	

   
	

	
	
}
