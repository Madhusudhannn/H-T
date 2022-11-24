package com.Humana.HumanaAnswer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Humana.HumanaAnswer.entity.Answers;

@Repository
public interface AnswerRepo extends JpaRepository<Answers, Integer>{

}
