package com.addbook.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addbook.app.model.Model;

@Repository
public interface AddressRepository extends JpaRepository<Model, Integer> {

	Optional<Model> findByName(String name);

	

	

}
