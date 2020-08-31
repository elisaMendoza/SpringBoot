package com.elisa.language.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elisa.language.models.Language;
import com.elisa.language.services.LanguageService;

@RestController
public class LanguageApi {
		private final LanguageService langService;
		public LanguageApi(LanguageService langService) {
			this.langService = langService;
		}
		@RequestMapping("/api/lang")
		public List<Language> index(){
			return langService.allLanguages();
		}
		@RequestMapping(value="/api/lang", method=RequestMethod.POST)
		public Language create(@RequestParam(value="name") String name,
							@RequestParam(value="creator") String creator,
							@RequestParam(value="version") String version) {
			Language lang = new Language(name, creator, version);
			return langService.createLanguage(lang);
		}
		@RequestMapping("/api/lang/{id}")
		public Language show(@PathVariable("id") Long id) {
			Language lang = langService.findLanguage(id);
			return lang;
		}
		@RequestMapping(value="/api/lang/{id}", method=RequestMethod.DELETE)
		public void destroy(@PathVariable("id") Long id) {
			langService.deleteLanguage(id);
		}

}
