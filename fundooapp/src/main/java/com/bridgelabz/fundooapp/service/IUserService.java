package com.bridgelabz.fundooapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bridgelabz.fundooapp.ResponseEntity;
import com.bridgelabz.fundooapp.dto.EmailDTO;
import com.bridgelabz.fundooapp.dto.Login;
import com.bridgelabz.fundooapp.dto.Register;
import com.bridgelabz.fundooapp.model.UserModel;

@Service
public interface IUserService {

    String addUser(UserModel user);

    Optional<UserModel> getname(String name);

    Optional<UserModel> getid(int id);

    Optional<UserModel> remove(String email);

    Optional<UserModel> delete(int id);

    UserModel update(UserModel user, String email);

    Register register(Register user);

    String getToken(Login loginDTO);

    Login getUserByLogin(Login loginDTO);

    UserModel getUserByLogin(String token);

    Login decode(String token);

    Register updateByToken(Register userDTO, String token);

    Object logoutByToken(String token);

    String sendMail(EmailDTO details);

    ResponseEntity add(Register userDTO);

}
