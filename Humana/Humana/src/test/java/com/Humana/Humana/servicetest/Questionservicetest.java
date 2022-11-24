package com.Humana.Humana.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Humana.Humana.Controller.QuestionsController;
import com.Humana.Humana.Entity.Questions;
import com.Humana.Humana.Entity.Users;
import com.Humana.Humana.advice.MailIdalreadyExist;
import com.Humana.Humana.advice.UserIdnotfound;
import com.Humana.Humana.dto.Allquestiondto;
import com.Humana.Humana.dto.QuestionUserDto;
import com.Humana.Humana.repo.QuestionsRepo;
import com.Humana.Humana.repo.UserRepository;
import com.Humana.Humana.services.Questionsservice;

@SpringBootTest
public class Questionservicetest {
	
	@InjectMocks
	private  Questionsservice questionservice;
	
	@Mock
	private  QuestionsRepo repo;
	@Mock
	private QuestionsController questoinscontrollertest;
	@Mock
	private UserRepository userrepo;
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void saveregistretion() throws MailIdalreadyExist, UserIdnotfound
	{
		Questions qu=new Questions();
		QuestionUserDto qusdto=new QuestionUserDto();
		when(questoinscontrollertest.savequestions(qusdto)).thenReturn(null);
		Questions response=questionservice.savequestion(qusdto); 
		assertEquals("Question saved sucessfully", qu.getQuestionId());
	} 
	@Test 
	public void getallquestions1()
	{
		List<Allquestiondto> qu=new ArrayList<>();
		when(questionservice.getquestions()).thenReturn(qu);
		List<Questions> result=repo.findAll();
		assertThat(result).isNotNull();
		assertEquals(0, qu.size());
	} 
	@Test
	public void byidtest1()
	{
		Users user =new Users(); 
		user.setUserId(1);
		when(questionservice.byUserid(1)).thenReturn(user);
		assertThat(userrepo.findById(1));

	}
	@Test
	public void byquid1()
	{
		Questions qu=new Questions();
		qu.setQuestionId(1);
		when(questionservice.byid(1)).thenReturn(qu);
		assertThat(repo.findById(1));
	}
 
}
