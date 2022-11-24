package com.Humana.HumanaAnswer.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Humana.HumanaAnswer.advice.UserIdnotfound;
import com.Humana.HumanaAnswer.advice.questionnotfound;
import com.Humana.HumanaAnswer.answerdto.AnswerDto;
import com.Humana.HumanaAnswer.entity.Answers;
import com.Humana.HumanaAnswer.entity.Questions;
import com.Humana.HumanaAnswer.entity.Users;
import com.Humana.HumanaAnswer.service.Answerservice;
import com.Humana.HumanaAnswer.util.Feignservice;

@RestController
@CrossOrigin
public class AnsController {

	@Autowired
	private Feignservice feignclient;
	@Autowired
	private Answerservice service;

//	@Autowired
//	private RestTemplate template;

//	@GetMapping("getquestions")
//	public List<Questions> getquestions() 
//	{
//		Questions[] data=template.getForObject("http://Questionshumana/api/auth/questions", Questions[].class);
//		return Arrays.asList(data);
//	}
	@GetMapping("getquestions1")
	public List<Questions> getquestions1() {
		List<Questions> data = feignclient.getquestions();
		return data;
	}

	@GetMapping("getquestionsbyid/{questionId}")
	public Questions getquestionbyid(@PathVariable Integer questionId) {
		Questions data = feignclient.getbyquestionid(questionId);
		return data;
	}

	@GetMapping("userid/{userId}")
	public Users byuserid(@PathVariable Integer userId) {
		Users data = feignclient.getbyid(userId);
		return data;
	}

	@PostMapping("saveanswer")
	public Map<String,String> saveanswer(@RequestBody AnswerDto answer) throws UserIdnotfound, questionnotfound {

		Map<String, String> map=new HashMap<String, String>();
		 service.answersave(answer);
		map.put("message", "Answer saved successfully");

		return map;
	} 

	@GetMapping("answers") 
	public List<Answers> answers() {
		return service.getanswers();
	}

}
