package com.bridgelabz.fundooapp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooapp.ResponseEntity;
import com.bridgelabz.fundooapp.dto.EmailDTO;
import com.bridgelabz.fundooapp.dto.Login;
import com.bridgelabz.fundooapp.dto.Register;
import com.bridgelabz.fundooapp.exceptions.UserException;
import com.bridgelabz.fundooapp.model.UserModel;
import com.bridgelabz.fundooapp.repository.UserRepository;
import com.bridgelabz.fundooapp.utilities.JavaMailService;
import com.bridgelabz.fundooapp.utilities.JwtTokenUtil;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    JavaMailService javaMailService;
    String token;

    @Override
    public String addUser(UserModel user) {
        // TODO Auto-generated method stub
        userRepo.save(user);
        return "user added successfully";
    }

    @Override
    public Optional<UserModel> getname(String name) {
        Optional<UserModel> getuserName = userRepo.findByName(name);
        if (getuserName.isEmpty()) {
            throw new UserException("User doesn't exist");
        } else
            return getuserName;
    }

    @Override
    public Optional<UserModel> getid(int id) {
        Optional<UserModel> getuserId = userRepo.findById(id);
        if (getuserId.isEmpty()) {
            throw new UserException("User doesn't exist");
        } else

            return getuserId;
    }

    @Override
    public Optional<UserModel> remove(String email) {
        Optional<UserModel> userModel = userRepo.findByEmail(email);
        if (userModel.isEmpty()) {
            throw new UserException("User doesn't exist");
        } else
            userRepo.deleteByEmail(email);
        return userModel;

    }

    @Override
    public Optional<UserModel> delete(int id) {

        Optional<UserModel> userModel = userRepo.findById(id);
        if (userModel.isEmpty()) {
            throw new UserException("User doesn't exist");
        } else
            userRepo.deleteById(id);
        return userModel;

    }

    @Override
    public UserModel update(UserModel user, String email) {
        user.setId(userRepo.findByEmail(email).get().getId());
        return userRepo.save(user);
    }

    @Override
    public Register register(Register user) {
        Optional<UserModel> userModel = userRepo.findByEmail(user.getEmail());
        if (userModel.isPresent()) {
            throw new UserException("User already exists");
        }
        UserModel registeredUser = modelMapper.map(user, UserModel.class);
        userRepo.save(registeredUser);
        System.out.println("Successfully registered");
        return user;

    }

    public String getToken(Login loginDTO) {
        Optional<UserModel> userModel = userRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if (userModel.isEmpty()) {
            throw new UserException("User Invalid!");
        }
        String token = jwtTokenUtil.generateToken(loginDTO);
        System.out.println("Successfully Fetched");
        return token;
    }

    @Override
    public Login getUserByLogin(Login loginDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserModel getUserByLogin(String token) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Login decode(String token) {
        Login user = jwtTokenUtil.deCode(token);

        // TODO Auto-generated method stub
        return user;
    }

    @Override
    public Register updateByToken(Register userDTO, String token) {

        Login loginDTO = jwtTokenUtil.deCode(token);
        UserModel userModel = modelMapper.map(userDTO, UserModel.class);
        if (userRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword()).isPresent()
                && userModel.getStatus() == 1) {
            userModel.setId(userRepo.findByEmail(loginDTO.getEmail()).get().getId());
            userModel.setIsVerified(true);
            userModel.setStatus(1);
            userRepo.save(userModel);
            return userDTO;
        } else {
            throw new UserException("Please Login!");
        }

    }

    @Override
    public Object logoutByToken(String token) {
        Login loginDTO = jwtTokenUtil.deCode(token);
        Optional<UserModel> checkUser = userRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        checkUser.get().setStatus(0);
        return "logout successful";
    }

    @Override
    public String sendMail(EmailDTO details) {

        return javaMailService.sendSimpleMail(details);
    }

    @Override
    public ResponseEntity add(Register userDTO) {
        String token;

        String userMail = userDTO.getEmail();
        if (userRepo.findByEmail(userMail).isPresent()) {
            throw new UserException("User already exist");

        } else {
            token = jwtTokenUtil.generateToken(userDTO.getEmail(), userDTO.getPassword());
            
            javaMailService.sendSimpleMail(userDTO.getEmail(),token,
                    "you email has sucessfully registered with token");
            UserModel userModel = modelMapper.map(userDTO, UserModel.class);
            userModel.setIsVerified(true);

            userRepo.save(userModel);
            return new ResponseEntity(userDTO, "One user added");

        }

    }

}
