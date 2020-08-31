package com.elisa.countries.repos;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.elisa.countries.models.Language;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Long>  {
	List<Language> findAll();
	
	@Query(value="SELECT c.name, l.language, l.percentage FROM countries c JOIN languages l ON c.id = l.country_id WHERE l.percentage > 89.9 ORDER BY percentage DESC", nativeQuery= true)
	List<Object[]> countriesLanguage();

}
