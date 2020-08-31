package com.elisa.dojosninjas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.elisa.dojosninjas.models.Ninja;
import com.elisa.dojosninjas.repos.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	NinjaRepository ninjaRepo;

	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
	public Ninja createNinja(Ninja n) {
        return ninjaRepo.save(n);
    }
    public Ninja findNinja(Long id) {
        Optional<Ninja> temp = ninjaRepo.findById(id);
        if(temp.isPresent()) {
            return temp.get();
        } else {
            return null;
        }
    }
	public void deleteNinja(Long id) {
       ninjaRepo.deleteById(id);
       }
	
	public Ninja updateNinja(Long id, String firstName, String lastName, int age) {
		Optional<Ninja> temp = ninjaRepo.findById(id);
		 if(temp.isPresent()) {
			 Ninja n = temp.get();
			 n.setFirstName(firstName);
			 n.setLastName(lastName);
			 n.setAge(age);
			 return ninjaRepo.save(n);
	        } else {
	        	return null;
	        }
	}

    public Ninja updateNinja(Ninja n) {
    	return ninjaRepo.save(n);
    }
    
    public List<Ninja> getAllNinjas(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Ninja> pagedResult = ninjaRepo.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Ninja>();
        }
    }
}
	

