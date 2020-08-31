package com.elisa.dojosninjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.elisa.dojosninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	  List<Dojo> findAll();
	  List<Dojo> findByNameContaining(String search);

}
