package com.Humana.HumanaAnswer.answerdto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerDto {
	private String answer;
	private Integer questionId;
	private Integer userId;
	private LocalDate dob;
	public String getAnswer() {
		return answer; 
	} 
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "AnswerDto [answer=" + answer + ", questionId=" + questionId + ", userId=" + userId + ", dob=" + dob
				+ "]";
	}
	
	
	

}
