package com.bridgelabz.fundooapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundooapp.dto.Login;
import com.bridgelabz.fundooapp.model.UserModel;

@Repository

public interface UserRepository  extends JpaRepository<UserModel, Integer> {
    
    Optional<UserModel> findByName(String name);
    Optional<UserModel> findById(int id);
    Optional<UserModel> deleteByEmail(String email);
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByEmailAndPassword(String email, String password);

    

   
    
    

}
