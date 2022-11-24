package com.Humana.Humana.advice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Humana.Humana.Response.ErrorResponse;



@RestControllerAdvice
public class Exceptionhandller {
 
	Logger logger=org.slf4j.LoggerFactory.getLogger(Exceptionhandller.class);
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleExceptions(MethodArgumentNotValidException ex) 
	{
		logger.info("MethodArgumentNotValidException method accessed");
		Map<String, String> map=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(err->
		map.put(err.getField(),err.getDefaultMessage())); 
		return map;
	}
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, String>> handleExceptions1(MethodArgumentNotValidException ex)
//	{
//		BindingResult bundingResult=ex.getBindingResult();
//		List<ObjectError> list=bundingResult.getAllErrors();
//		
//		Map<String, String> map=new HashMap<>();
//		for (ObjectError objectError : list) {
//			map.put(((FieldError)objectError).getField(),objectError.getDefaultMessage());
//		}
//		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
//		
//    }
 
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MailIdalreadyExist.class)
	public Map<String, String> mailalreadyexist(MailIdalreadyExist ex)
	{
		logger.info("MailIdalreadyExist method acessed");
		Map<String, String> error=new HashMap<>();
		error.put("errormessage", ex.getMessage());
		return error;
	}
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserIdnotfound.class)
	public Map<String, String> useridnotfound(UserIdnotfound ex)
	{
		logger.info("UserIdnotfound method acessed");
		Map<String, String> error=new HashMap<>();
		error.put("errormessage", ex.getMessage());
		return error;
	}
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(membernotfound.class)
	public Map<String, String> membernotfound(membernotfound ex)
	{
		logger.info("membernotfound method acessed");
		Map<String, String> error=new HashMap<>();
		error.put("errormessage", ex.getMessage());
		return error;
	}
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(Exception.class)
	public ErrorResponse handleException(Exception exe)
	{
		ErrorResponse r=new ErrorResponse();
		r.setErrocode("General"); 
		r.setDescription(exe.getMessage());
		r.setException(exe);
		return  r;   
	} 
	
	
} 
