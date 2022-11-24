package com.Humana.HumanaAnswer.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Humana.HumanaAnswer.entity.Questions;
import com.Humana.HumanaAnswer.entity.Users;

@Service
@FeignClient(value="QUESTIONSHUMANA")
public interface Feignservice {
	
	@GetMapping("/api/auth/questions")
	public List<Questions> getquestions();
   
	@GetMapping("/api/auth/Users/id/{userId}")
	public Users getbyid(@PathVariable Integer userId);
	
	@GetMapping("/api/auth/questions/id/{questionId}")
	public Questions getbyquestionid(@PathVariable Integer questionId);
}
