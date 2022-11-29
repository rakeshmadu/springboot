package com.addbook.app.service;

import com.addbook.app.exception.UserException;
import com.addbook.app.model.Model;
import com.addbook.app.repository.AddressRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddService implements Iservice {
	@Autowired
	AddressRepository addRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public Model register(Model name) {

		Optional<Model> addModel = addRepo.findByName(name.getName());
		if (addModel.isPresent()) {
			throw new UserException("user already exists");
		}
		Model registeredUser = modelMapper.map(name, Model.class);
		addRepo.save(registeredUser);
		System.out.println("Successfully registered");
		return name;

	}

	@Override
	public Model update(Model user, int id) {

		user.setUserid(id);
		return addRepo.save(user);
	}


	@Override
	public Optional<Model> delete(int id) {

		Optional<Model> usrModel = addRepo.findById(id);
		if (usrModel.isEmpty()) {
			throw new UserException("User doesn't exist");
		} else
			addRepo.deleteById(id);
		return usrModel;

	}

	@Override
	public List<Model> getAlldata() {

		List<Model> addbook = new ArrayList<Model>();
		addRepo.findAll().forEach(add1 -> addbook.add(add1));
		return addbook;
	}
}
