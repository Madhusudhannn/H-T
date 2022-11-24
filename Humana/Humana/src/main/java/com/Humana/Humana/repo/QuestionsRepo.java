package com.Humana.Humana.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Humana.Humana.Entity.Questions;
import com.Humana.Humana.Entity.Users;
@Repository
public interface QuestionsRepo extends JpaRepository<Questions, Integer> {
	
	public Questions findByQuestionId(Integer questionId);

	public Object save(Users user);

	

	

}
