package com.Humana.HumanaAnswer.advicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.Humana.HumanaAnswer.advice.Exceptionhandller;
import com.Humana.HumanaAnswer.response.ErrorResponse;

@SpringBootTest
public class Exceptiontest {

	@InjectMocks
	private Exceptionhandller exceptionhandller;
	
	@Test
	public void exceptionTest()
	{
		Exception exe=new Exception();
		ErrorResponse  erroor= exceptionhandller.handleException(exe);
		ErrorResponse r=new ErrorResponse();
		r.setErrocode("General");  
		r.setDescription(exe.getMessage());
		r.setException(exe);
		assertNotNull(erroor);
		 
	}
	
}
