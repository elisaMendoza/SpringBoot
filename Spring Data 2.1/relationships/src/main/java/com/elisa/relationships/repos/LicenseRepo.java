package com.elisa.relationships.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elisa.relationships.models.License;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long> {
	
	Long countByStateContaining(String search);
	
	List<License> findTopByOrderByNumberDesc();

}
