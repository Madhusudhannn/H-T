package com.Humana.HumanaAnswer.controllertest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.Humana.HumanaAnswer.Controller.AnsController;
import com.Humana.HumanaAnswer.advice.UserIdnotfound;
import com.Humana.HumanaAnswer.advice.questionnotfound;
import com.Humana.HumanaAnswer.answerdto.AnswerDto;
import com.Humana.HumanaAnswer.entity.Answers;
import com.Humana.HumanaAnswer.entity.Questions;
import com.Humana.HumanaAnswer.entity.Users;
import com.Humana.HumanaAnswer.service.Answerservice;
import com.Humana.HumanaAnswer.util.Feignservice;


@SpringBootTest
public class Controlertest {

	@InjectMocks
	private AnsController anscontroller;
	
	@Mock
	private Answerservice anssrvice;
	@Mock
	private Feignservice service;
	
	
	
	@Test
	public void getquestiontest()
	{
		List<Questions> qu=new ArrayList<>();
		when(anscontroller.getquestions1()).thenReturn(qu);
		List<Questions> result=service.getquestions();
		assertThat(result).isNotNull();
		assertEquals(0, qu.size());
	}
	@Test
	public void byuserid()
	{ 
		Users user=new Users();
		user.setUserId(1);
		when(anscontroller.byuserid(1)).thenReturn(user);
		assertThat(service.getbyid(1));
	}
	@Test
	public void byquestionId()
	{ 
		Questions question=new Questions();
		question.setQuestionId(1);
		when(anscontroller.getquestionbyid(1)).thenReturn(question);
		assertThat(service.getbyquestionid(1));
	}
	@Test 
	public void getalltest() {
		List<Answers> answers = new ArrayList<Answers>();
		Answers ans=new Answers();
		ans.setAnswer("ans");
		
		when(anscontroller.answers()).thenReturn(answers);
		List<Answers> result = anssrvice.getanswers();
		assertThat(result).isNotNull();
		assertEquals(0, answers.size()); 
	}
	@Test
	public void saveanswertest() throws UserIdnotfound, questionnotfound
	{
		Answers ans=new Answers();
		AnswerDto ansdto=new AnswerDto();
		when(anssrvice.answersave(ansdto)).thenReturn(ans);
		Map<String, String> response=anscontroller.saveanswer(ansdto); 
		assertEquals("answer saved sucessfully", ans.getAnswerId());
		
	}
	@Test
	public void usertest()
	{
		Users user=new Users();
		user.setUserId(1);
		user.setFirstName("madhu");
		user.setLastName("sudhan");
		user.setEmailID("madhu@gmail.com");
		user.setPassword("password");
		user.setDob(LocalDate.now());
		user.setRoles(null);
		String name = user.getFirstName();
		assertEquals("madhu", name);
	}
	@Test
	public void questiontest()
	{
		Questions qu=new Questions();
		qu.setQuestion("question");
		qu.setDescription("description");
		qu.setUser(null);
		qu.setDob(LocalDate.now());
		qu.setQuestionId(1);
		String question=qu.getQuestion();
		assertEquals("question", question);
	}
	@Test
	public void answertest()
	{
		Answers ans=new Answers();
		ans.setAnswer("answer");
		ans.setAnswerId(1);
		ans.setDob(LocalDate.now());
		ans.setQuestions(null);
		ans.setUser1(null);
		String ans1=ans.getAnswer();
		assertEquals("answer", ans1);
	}
	
}
