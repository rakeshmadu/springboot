package com.addbook.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.addbook.app.ResponseEntity;
import com.addbook.app.model.Model;
import com.addbook.app.service.Iservice;


@RestController
public class Controller {
	@Autowired //The @Autowired annotation marks a Constructor, Setter method, Properties and Config() method as to be autowired that is ‘injecting beans'(Objects) at runtime by Spring Dependency Injection mechanism 
	Iservice addService;

	@PostMapping("/register") // registering new entry
	public ResponseEntity registerAddress(@RequestBody Model addbook) {
		Model addSave = addService.register(addbook);
		return new ResponseEntity(addSave, "Registered successfully");
	}
	
	@PutMapping("/update/{id}") //update data of user
	public ResponseEntity updateUser(@RequestBody Model user, @PathVariable int id) {
		Model userUpdate = addService.update(user,id);
		return new ResponseEntity(userUpdate, "user updated successfully");
	}
	
	@DeleteMapping("/delete/{id}") // deletes  data by id 
	public Optional<Model> deleteUsr(@PathVariable int id) {
		Optional<Model> usrModel = addService.delete(id);
		System.out.println("user deleted");
		return usrModel;
	}
	
	@GetMapping("/getAll") // displays all  details
	public List<Model> getAlldata() {

		return addService.getAlldata();
	}


}
