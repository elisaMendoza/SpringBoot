package com.elisa.countries.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elisa.countries.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long> {
	List<Country> findAll();
	
	 @Query(value="SELECT c.name, l.language, l.percentage FROM countries c JOIN languages l ON c.id = l.country_id WHERE language = 'Slovene' ORDER BY percentage DESC", nativeQuery=true)
	    List<Object[]> joinCountriesandLanguages();
	 
	    @Query(value="SELECT co.name, COUNT(ci.id) as 'Number of cities' FROM countries co JOIN cities ci ON co.id=ci.country_id GROUP BY co.name ORDER BY COUNT(ci.id) DESC", nativeQuery=true)
	    List<Object[]> joinCountriesCities();
	    
	    @Query(value="SELECT name, surface_area, population FROM countries WHERE surface_area < 501 AND population > 100000 ", nativeQuery= true)
	    List<Object[]> countrieSurfaceandPop();
	    
	    @Query(value="SELECT name, government_form, surface_area FROM countries WHERE government_form LIKE '%Monarchy%' AND life_expectancy > 75", nativeQuery= true)
	    List<Object[]> monarchies();
	    
	    @Query(value="SELECT region, COUNT(*) as 'Number of countries' FROM countries GROUP BY region ORDER BY COUNT(*) DESC", nativeQuery= true)
	    List<Object[]> regions();

}
