package com.addbook.app.service;

import com.addbook.app.model.Model;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public interface Iservice {

	Model register(Model addbook);

	Model update(Model user, int id);

	Optional<Model> delete(int id);

	List<Model> getAlldata();

	

}
