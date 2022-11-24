package com.Humana.HumanaAnswer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Humana.HumanaAnswer.advice.UserIdnotfound;
import com.Humana.HumanaAnswer.advice.questionnotfound;
import com.Humana.HumanaAnswer.answerdto.AnswerDto;
import com.Humana.HumanaAnswer.answerdto.Questionanswerdto;
import com.Humana.HumanaAnswer.entity.Answers;
import com.Humana.HumanaAnswer.entity.Questions;
import com.Humana.HumanaAnswer.entity.Users;
import com.Humana.HumanaAnswer.repo.AnswerRepo;
import com.Humana.HumanaAnswer.util.Feignservice;

@Service
public class Answerservice {
	  
	@Autowired 
	public AnswerRepo answerrepo;
	
	@Autowired
	public Feignservice feignclient; 
	 
	public Answers answersave(AnswerDto answerdto) throws UserIdnotfound, questionnotfound
	{ 
		 
		
		Users user=feignclient.getbyid(answerdto.getUserId());
		Questions qu=feignclient.getbyquestionid(answerdto.getQuestionId());
		if(user!=null) {
			if(qu!=null) 
			{
		Answers answers=new Answers();
		answers.setAnswer(answerdto.getAnswer());
		answers.setDob(answerdto.getDob()); 
		answers.setQuestions(qu);  
		answers.setUser1(user); 
		return answerrepo.save(answers); 
			}
			else
			{
				throw new questionnotfound("quention not found");
			}
		}
		else
		{
			throw new UserIdnotfound("user not found");
		}
	}
	 
	public List<Answers> getanswers()
	{
		return answerrepo.findAll();
	 
	}
}
