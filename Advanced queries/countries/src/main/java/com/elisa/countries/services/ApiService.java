package com.elisa.countries.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.elisa.countries.repos.CityRepo;
import com.elisa.countries.repos.CountryRepo;
import com.elisa.countries.repos.LanguageRepo;

@Service
public class ApiService {
	private final CountryRepo cRep;
	private final CityRepo cityRep;
	private final LanguageRepo lanRepo;
	
	public ApiService(CountryRepo cRep, CityRepo cityRep, LanguageRepo lanRepo ) {
		this.cRep = cRep;
		this.cityRep = cityRep;
		this.lanRepo = lanRepo;
	}
	public List<Object[]> question1(){
	    	List<Object[]> table = cRep.joinCountriesandLanguages();
	    	return table;
	    }
   public List<Object[]> question2(){
    	List<Object[]> table = cRep.joinCountriesCities();
    	return table;
    }
   public List<Object[]> question3(){
   	List<Object[]> table = cityRep.citiesPopulation();
   	return table;
   }
   public List<Object[]> question4(){
	   	List<Object[]> table = lanRepo.countriesLanguage();
	   	return table;
	   }
   public List<Object[]> question5() {
	   List<Object[]> table = cRep.countrieSurfaceandPop();
	   return table;
   }
   public List<Object[]> question6() {
	   List<Object[]> table = cRep.monarchies();
	   return table;
   }
   public List<Object[]> question7() {
	   List<Object[]> table = cityRep.argentina();
	   return table;
   }
   public List<Object[]> question8() {
	   List<Object[]> table = cRep.regions();
	   return table;
   }
}
