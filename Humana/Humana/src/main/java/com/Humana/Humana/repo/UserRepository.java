package com.Humana.Humana.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Humana.Humana.Entity.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
   Users findByFirstName(String firstName);
   public Users findByUserId(Integer userId);
   public Users findByEmailID(String emailID);
 
   Boolean existsByEmailID(String emailID);  





}
