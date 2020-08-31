package com.elisa.dojosninjas.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.elisa.dojosninjas.models.Ninja;

@Repository
public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long> {
	List<Ninja> findAll();
	Page<Ninja> findAll(Pageable pageable);
	Long countByFirstNameContaining(String search);  
}
