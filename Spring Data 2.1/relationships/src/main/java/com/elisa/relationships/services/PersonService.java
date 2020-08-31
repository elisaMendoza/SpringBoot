package com.elisa.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.elisa.relationships.models.Person;
import com.elisa.relationships.repos.PersonRepo;

@Service
public class PersonService {
	private final PersonRepo personRepo;
	
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	public List<Person> allPersons() {
		return personRepo.findAll();
	}
	public Person createPerson(Person p) {
		return personRepo.save(p);
	}
	public Person findPerson(Long id) {
        Optional<Person> option = personRepo.findById(id);
        if(option.isPresent()) {
            return option.get();
        } else {
            return null;
        }
	}
		public void deletePerson(Long id) {
	       personRepo.deleteById(id);
	       }
		
		public Person updatePerson(Long id, String firstName, String lastName) {
			Optional<Person> temp = personRepo.findById(id);
			 if(temp.isPresent()) {
				 Person p = temp.get();
				 p.setFirstName(firstName);
				 p.setLastName(lastName);
				 return personRepo.save(p);
		        } else {
		        	return null;
		        }
		}	
	    public Person updatePerson(Person p) {
	    	return personRepo.save(p);
	    }

}
