package com.elisa.relationships.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elisa.relationships.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {
	List<Person> findAll();
	
	Long deleteByFirstNameContaining(String search);

}
