package com.Humana.Humana.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Humana.Humana.Entity.Questions;
import com.Humana.Humana.Entity.Users;
import com.Humana.Humana.Response.MessageResponse;
import com.Humana.Humana.advice.MailIdalreadyExist;
import com.Humana.Humana.advice.UserIdnotfound;
import com.Humana.Humana.advice.membernotfound;
import com.Humana.Humana.dto.Allquestiondto;
import com.Humana.Humana.dto.QuestionUserDto;
import com.Humana.Humana.repo.QuestionsRepo;
import com.Humana.Humana.repo.UserRepository;
import com.Humana.Humana.request.LoginRequest;
import com.Humana.Humana.services.Questionsservice;

@RestController
@CrossOrigin 
@RequestMapping("/api/auth")
public class QuestionsController {

	@Autowired
	private Questionsservice questionservice;
	@Autowired
	private QuestionsRepo questionsrepo;
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userrepo;

	@PostMapping("/userregister")
	public Map<String, String> save(@RequestBody Users user) throws MailIdalreadyExist {
		Map<String, String> map = new HashMap<String, String>();
		Users user1 = questionservice.saveuser(user);
		Integer us = user1.getUserId();
//		ResponseEntity response = new ResponseEntity("user successfully registred:" + us, HttpStatus.OK);
		map.put("message", "user successfully registred:" + us);
		return map;

	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginrequest) throws membernotfound {
		Users user = userrepo.findByEmailID(loginrequest.getEmailID());

		if ((user != null) && (encoder.matches(loginrequest.getPassword(), user.getPassword()))) {
			return ResponseEntity.ok(new MessageResponse("Login successfully"));
		} else {
			throw new membernotfound("Please enter correct data");
		}

	}

	@PostMapping("/savequestions")
	public ResponseEntity<Questions> savequestions(@RequestBody QuestionUserDto questions) throws UserIdnotfound {

		Questions quu = questionservice.savequestion(questions);
		ResponseEntity<Questions> rs = null;
		if (quu != null) {
			rs = new ResponseEntity<Questions>(quu, HttpStatus.OK);
		} else {
			rs = new ResponseEntity<Questions>(quu, HttpStatus.NOT_FOUND);
		}
		return rs;
	}

	@GetMapping("/questions")
	public List<Allquestiondto> getQuestions() {
		return questionservice.getquestions();
	}

	@GetMapping("/Users/id/{userId}")
	public Users getbyUserId(@PathVariable Integer userId) {
		return questionservice.byUserid(userId);
	}

	@GetMapping("/questions/id/{questionId}")
	public Questions getbyId(@PathVariable Integer questionId) {
		return questionservice.byid(questionId);
	}

}
