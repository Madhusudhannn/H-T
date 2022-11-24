package com.Humana.HumanaAnswer.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Answers")

public class Answers {
	
	@Id
	@GeneratedValue 
	private Integer answerId;
	private String answer;
	@ManyToOne
	@JoinColumn(name="fkqiid")
	private Questions questions;
	@ManyToOne
	@JoinColumn(name="fkuiid")
	private Users user1;
	private LocalDate dob;
	
	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	} 
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	
	public Users getUser1() {
		return user1;
	}
	public void setUser1(Users user1) {
		this.user1 = user1;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Answers [answerId=" + answerId + ", answer=" + answer + ", questions=" + questions + ", user1=" + user1
				+ ", dob=" + dob + "]";
	}
	
	

}
