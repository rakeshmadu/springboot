package com.bridgelabz.fundooapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*import org.springframework.web.bind.annotation.RequestParam;*/
import org.springframework.web.bind.annotation.RequestParam;

import com.bridgelabz.fundooapp.ResponseEntity;
import com.bridgelabz.fundooapp.dto.Login;
import com.bridgelabz.fundooapp.dto.Register;
import com.bridgelabz.fundooapp.model.UserModel;
import com.bridgelabz.fundooapp.service.IUserService;

@RestController

public class Controller {
    @Autowired
    IUserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello User";
    }

    /*
     * @PostMapping("/add")
     * public String addUser(@RequestBody UserModel user) {
     * 
     * String userModel = userService.addUser(user);
     * return userModel;
     * }
     */

    @GetMapping("/find/{name}")
    // public Optional<UserModel> searchByName(@RequestParam String name) {
    public Optional<UserModel> searchByName(@PathVariable String name) {
        System.out.println("User found : " + name);
        Optional<UserModel> searchUser = userService.getname(name);

        return searchUser;
    }

    @GetMapping("/findid/{id}")
    public Optional<UserModel> getById(@PathVariable int id) {
        System.out.println("id found :" + id);
        Optional<UserModel> searchId = userService.getid(id);
        return searchId;

    }

    @Transactional
    @DeleteMapping("/del/{email}")
    public Optional<UserModel> delete(@PathVariable String email) {
        Optional<UserModel> userModel = userService.remove(email);
        System.out.println("User deleted Successfully");
        return userModel;
    }

    @DeleteMapping("/delete/{id}")
    public Optional<UserModel> deleteUser(@PathVariable int id) {
        Optional<UserModel> userModel = userService.delete(id);
        System.out.println("User deleted");
        return userModel;
    }

  
    @PutMapping("/update/{email}")
    public ResponseEntity updateUser(@RequestBody UserModel user, @PathVariable String email) {
        UserModel userUpdate = userService.update(user, email);
        return new ResponseEntity(userUpdate, "User updated ");
    }
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody Register user) {
        Register registerDTO = userService.register(user);
        return new ResponseEntity(registerDTO, "Registered successfully");
    }
    
    @GetMapping("/getToken")
    public String getToken(@RequestBody Login loginDTO) {
        String token = userService.getToken(loginDTO);
        
        return token;
    }
    @GetMapping("/decode")
    public Login decodetoken(@RequestParam  String token ) {
        Login user = userService.decode(token);
        return user;
    }
    
}

