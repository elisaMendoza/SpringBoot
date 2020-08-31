package com.elisa.countries.repos;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.elisa.countries.models.City;

@Repository
public interface CityRepo extends CrudRepository<City, Long> {
	List<City> findAll();
	
	@Query(value="SELECT name, population FROM `cities` WHERE population > 500000 ORDER BY population DESC ", nativeQuery= true)
	List<Object[]> citiesPopulation();
	
	@Query(value="SELECT countries.name, cities.name as 'city', cities.district, cities.population FROM countries JOIN cities ON countries.id = cities.country_id WHERE countries.name LIKE 'Argentina' AND cities.population > 500000", nativeQuery= true)
	List<Object[]> argentina();
	

}
