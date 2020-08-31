package com.elisa.dojosninjas.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.elisa.dojosninjas.models.Dojo;
import com.elisa.dojosninjas.repos.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;

	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	public List<Dojo> allDojos() {
	        return dojoRepo.findAll();
	    }
	public Dojo createDojo(Dojo d) {
        return dojoRepo.save(d);
    }
    public Dojo findDojo(Long id) {
        Optional<Dojo> temp = dojoRepo.findById(id);
        if(temp.isPresent()) {
            return temp.get();
        } else {
            return null;
        }
    }
	public void deleteDojo(Long id) {
       dojoRepo.deleteById(id);
       }
	
	public Dojo updateDojo(Long id, String name) {
		Optional<Dojo> temp = dojoRepo.findById(id);
		 if(temp.isPresent()) {
			 Dojo d = temp.get();
			 d.setName(name);
			 return dojoRepo.save(d);
	        } else {
	        	return null;
	        }
	}
    public Dojo updateDojo(Dojo d) {
    	return dojoRepo.save(d);
    }
}
