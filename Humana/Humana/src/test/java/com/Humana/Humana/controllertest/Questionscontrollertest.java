package com.Humana.Humana.controllertest;

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
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.Humana.Humana.Controller.QuestionsController;
import com.Humana.Humana.Entity.Questions;
import com.Humana.Humana.Entity.Users;
import com.Humana.Humana.advice.MailIdalreadyExist;
import com.Humana.Humana.dto.Allquestiondto;
import com.Humana.Humana.dto.QuestionUserDto;
import com.Humana.Humana.repo.QuestionsRepo;
import com.Humana.Humana.services.Questionsservice;



@SpringBootTest
public class Questionscontrollertest {
 
	@InjectMocks
	private QuestionsController questoinscontrollertest;
	
	@Mock
	private Questionsservice questionsservicetest;
	@Mock
	private QuestionsRepo qurepo;
	@Mock
	private QuestionUserDto dto;
	
	@Test
	public void saveregistretion() throws MailIdalreadyExist
	{
		Users user=new Users();
		user.setUserId(1);
		user.setFirstName("madhu");
		user.setLastName("sudhan");
		user.setPassword("password");
		user.setEmailID("emailId");
		user.setDob(null);
		user.setRoles(null);
		Mockito.when(questionsservicetest.saveuser(user)).thenReturn(user);
		Map<String, String> saveuser = questoinscontrollertest.save(user);
		assertThat(saveuser.equals(" User registred successfully"));
	} 
	@Test
	public void questionstest() throws Exception
	{
//		QuestionUserDto questions=new QuestionUserDto();
//		questions.setDescription("language");
//		questions.setQuestion("questions");
//		Mockito.when(questionsservicetest.savequestion(questions));
//		ResponseEntity<Questions> savequestions=questoinscontrollertest.savequestions(questions);
//		assertThat(savequestions.equals(" Questioned is saved")); 
		Questions ans=new Questions();
		QuestionUserDto ansdto=new QuestionUserDto();
		when(questionsservicetest.savequestion(ansdto)).thenReturn(ans);
		ResponseEntity<Questions> response=questoinscontrollertest.savequestions(ansdto); 
		assertEquals("answer saved sucessfully", ans.getQuestionId());
		
	} 
	@Test
	public void getallquestions()
	{
		List<Allquestiondto> qu=new ArrayList<>();
		when(questionsservicetest.getquestions()).thenReturn(qu);
		List<Questions> result=qurepo.findAll();
		assertThat(result).isNotNull();
		assertEquals(0, qu.size());
	}
	@Test
	public void byidtest()
	{
		Users user =new Users();
		user.setUserId(1);
		when(questionsservicetest.byUserid(1)).thenReturn(user);
		assertThat(questoinscontrollertest.getbyUserId(1));
	}
	@Test
	public void byquid()
	{
		Questions qu=new Questions();
		qu.setQuestionId(1);
		when(questionsservicetest.byid(1)).thenReturn(qu);
		assertThat(questoinscontrollertest.getbyId(1));
	}
	@Test
	public void savequestiontest() throws Exception
	{
		Questions qu=new Questions();
		QuestionUserDto qusdto=new QuestionUserDto();
		when(questionsservicetest.savequestion(qusdto)).thenReturn(qu);
		ResponseEntity<Questions> response=questoinscontrollertest.savequestions(qusdto); 
		assertEquals("Question saved sucessfully", qu.getQuestionId());
		
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

}
