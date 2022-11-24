package com.Humana.HumanaAnswer.dtotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.Humana.HumanaAnswer.answerdto.AnswerDto;
import com.Humana.HumanaAnswer.answerdto.Questionanswerdto;

@SpringBootTest
public class Dtotest {

	@InjectMocks
	private AnswerDto ansdto;
	
	@InjectMocks
	private Questionanswerdto dto;
	
	AnswerDto ans=new AnswerDto();
	Questionanswerdto qu=new Questionanswerdto();
	
	@Test
	public void iDtest() {
		ans.setUserId(1);
		Integer id = ans.getUserId();
		assertEquals(1, id);

	}

	@Test
	public void answer() {
		ans.setAnswer("answer");
		String an1 = ans.getAnswer();
		assertEquals("answer", an1);

	}
	@Test
	public void questionid() {
		ans.setQuestionId(1);
		Integer id = ans.getQuestionId();
		assertEquals(1, id);

	}
	@Test
	public void dob() {
		ans.setDob(null);
		LocalDate an1 = ans.getDob();
		assertEquals(null, an1);

	}
	@Test
	public void answer1() {
		qu.setAnswer("answer");
		String an1 = ans.getAnswer();
		assertEquals("answer", an1);
	}
	@Test
	public void question() {
		qu.setQuestion("question");
		String an1 = qu.getQuestion();
		assertEquals("question", an1);
	}
}
