package com.Humana.HumanaAnswer.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Humana.HumanaAnswer.Controller.AnsController;
import com.Humana.HumanaAnswer.advice.UserIdnotfound;
import com.Humana.HumanaAnswer.advice.questionnotfound;
import com.Humana.HumanaAnswer.answerdto.AnswerDto;
import com.Humana.HumanaAnswer.entity.Answers;
import com.Humana.HumanaAnswer.entity.Questions;
import com.Humana.HumanaAnswer.entity.Users;
import com.Humana.HumanaAnswer.repo.AnswerRepo;
import com.Humana.HumanaAnswer.service.Answerservice;
import com.Humana.HumanaAnswer.util.Feignservice;


@SpringBootTest
public class Servicetest {
	
	@InjectMocks
	private Answerservice ansservice;
	@Mock
	private AnswerRepo repo;
	@Mock
	private AnsController anscontroller;
	
	@Mock
	private Feignservice service;
	@Test
	public void getalltest() {
		List<Answers> answers = new ArrayList<Answers>();
		
	    when(ansservice.getanswers()).thenReturn(answers);
		List<Answers> result = repo.findAll();
		assertThat(result).isNotNull();
		assertEquals(0, answers.size()); 
	}
	@Test
	public  void anssave() throws UserIdnotfound, questionnotfound
	{
		
		AnswerDto dto=new AnswerDto();
		Map<String, String> ans=new HashMap<String, String>();
		dto.setUserId(1);
		dto.setQuestionId(2);
		dto.setAnswer("answer");
		dto.setDob(LocalDate.now());
		when(anscontroller.saveanswer(dto)).thenReturn(ans);
		Answers answer=ansservice.answersave(dto); 
		assertThat(answer.equals("Answer saved successfully"));
		
		
//		Users user=service.getbyid(answerdto.getUserId());
//		Questions qu=service.getbyquestionid(answerdto.getQuestionId());
//		Answers answers=new Answers();
//		answers.setAnswer(answerdto.getAnswer()); 
//		answers.setDob(answerdto.getDob());
//		answers.setQuestions(qu);
//		answers.setUser1(user);  
//		when(repo.save(answers)).thenReturn(answers);
//		Answers saveanswer=ansservice.answersave(answerdto);
//		assertThat(saveanswer.equals("Answer saved succefully"));
	}
	
	
}
