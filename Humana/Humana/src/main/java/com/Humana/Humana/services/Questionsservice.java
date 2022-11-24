 package com.Humana.Humana.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Humana.Humana.Entity.Questions;
import com.Humana.Humana.Entity.Users;
import com.Humana.Humana.advice.MailIdalreadyExist;
import com.Humana.Humana.advice.UserIdnotfound;
import com.Humana.Humana.dto.Allquestiondto;
import com.Humana.Humana.dto.QuestionUserDto;
import com.Humana.Humana.repo.QuestionsRepo;
import com.Humana.Humana.repo.UserRepository;


@Service
public class Questionsservice {

	@Autowired
	private UserRepository userrepo; 
	
	@Autowired
	private QuestionsRepo questionsrepo;
	@Autowired
	private PasswordEncoder encoder;
	public Users saveuser(Users user) throws MailIdalreadyExist
	{
		Users us=userrepo.findByEmailID(user.getEmailID());
		if(us==null) 
		{
 
		String pass=encoder.encode(user.getPassword());
		Users user1=new Users();
		
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setEmailID(user.getEmailID());
		user1.setRoles(user.getRoles());
		user1.setPassword(pass);
		user1.setDob(user.getDob()); 
		userrepo.save(user1); 
		return user1;  
		}
		else
		{
			throw new MailIdalreadyExist("Mail already exist");
		}
	} 

	
	public Questions savequestion(QuestionUserDto questions) throws UserIdnotfound  
	{ 
		
		Users user=userrepo.findByUserId(questions.getUserId());
		if(user!=null) {
		Questions questions1=new Questions();
		Optional<Users> us=userrepo.findById(questions.getUserId());
		Users us1=us.get();
		questions1.setDescription(questions.getDescription());
		questions1.setQuestion(questions.getQuestion());
		questions1.setUser(us1);
		questions1.setDob(questions.getDob());
		  questionsrepo.save(questions1); 
		  return questions1;
		}
		else
		{
			throw new UserIdnotfound("Userid not found");
		}
		
		
	}
	public List<Allquestiondto> getquestions()
	{
		
		List<Allquestiondto> list=new ArrayList<>();
		
		 List<Questions> qu=questionsrepo.findAll();
		 for (Questions questions : qu) {
			 Allquestiondto dto=new Allquestiondto();
			 dto.setDescription(questions.getDescription());
			 dto.setQuestion(questions.getQuestion());
			 dto.setDob(questions.getDob());
			 dto.setQuestionId(questions.getQuestionId());
			 list.add(dto);
	 		}
		return list;
		
	}
	public Users byUserid(Integer  userId)
	{
		Users user=userrepo.findByUserId(userId);
		return user;
	}
	public Questions byid(Integer questionId)
	{
		
		Questions question=questionsrepo.findByQuestionId(questionId);
		return question;
	}
	
//	public LoginRequest login(Users user)
//	{
//		LoginRequest login=new LoginRequest();
//		String pass=encoder.encode(user.getPassword());
//		Users user1=new Users();
//		user1.setEmailID(user.getEmailID());
//		userrepo.save(user1);
//		login.setEmailID(emailID);
//		if(user1.getEmailID()==login.getEmailID())
//		{
//			return "";
//		}
//		
//	}
	
}
