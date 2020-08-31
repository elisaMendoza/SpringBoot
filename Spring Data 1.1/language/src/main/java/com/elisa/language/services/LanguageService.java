package com.elisa.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elisa.language.models.Language;
import com.elisa.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	//Agregando el lenguaje al repositorio como una dependencia
    private final LanguageRepository lanRepo;
    
    public LanguageService(LanguageRepository lanRepo) {
        this.lanRepo = lanRepo;
    }
    //Devolviendo todos los lenguajes.
    public List<Language> allLanguages() {
        return lanRepo.findAll();
    }
    //Creando un lenguaje.
    public Language createLanguage(Language lan) {
        return lanRepo.save(lan);
    }
    //Obteniendo la información de un lenguaje
    public Language findLanguage(Long id) {
        Optional<Language> optionalLan = lanRepo.findById(id);
        if(optionalLan.isPresent()) {
            return optionalLan.get();
        } else {
            return null;
        }
    }
	public void deleteLanguage(Long id) {
       lanRepo.deleteById(id);
       }
		
	public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
		Optional<Language> temp = lanRepo.findById(id);
		 if(temp.isPresent()) {
			 Language lan = temp.get();
			 lan.setName(name);
			 lan.setCreator(creator);
			 lan.setCurrentVersion(currentVersion);
			 return lanRepo.save(lan);
	        } else {
	        	return null;
	        }
	}
    public Language updateLanguage(Language lan) {
    	return lanRepo.save(lan);
    }
  

}
