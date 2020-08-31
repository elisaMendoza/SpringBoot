package com.elisa.dojoverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elisa.dojoverflow.models.Answer;
import com.elisa.dojoverflow.models.Question;
import com.elisa.dojoverflow.models.Tag;
import com.elisa.dojoverflow.models.TagList;
import com.elisa.dojoverflow.services.DojoService;

@Controller
@RequestMapping("/questions")
public class DojoController {
	private final DojoService service;
	public DojoController(DojoService service) {
		this.service = service;
	}
	
	@RequestMapping("")
	public String questions(Model model) {
		model.addAttribute("questions", service.allQuestions());
		return "questions.jsp";
	}
	@RequestMapping("/new")
	public String addQuestionPage(@ModelAttribute("newQuestion") Question question) {
		return "newQuestion.jsp";
	}
	@PostMapping("/new")
	public String addQuestion(@Valid @ModelAttribute("newQuestion") Question question, BindingResult result, @RequestParam(value="tagList") String tags) {
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		}
		TagList list = new TagList(tags);
		Question savedQuestion = service.addQuestion(question);
		for(String val:list.getTags()) {
			if(service.allTagNames().contains(val) == false) {
				Tag savedTag = service.addTag(new Tag(val));
				service.addQuestionTag(savedQuestion, savedTag);
			} else {
				service.addQuestionTag(savedQuestion, service.findTagByName(val));
			}
		}
		return "redirect:/questions/new";
	}
	@RequestMapping("/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("newAnswer") Answer answer) {
		model.addAttribute("question", service.findQuestion(id));
		for(Answer val:service.findQuestion(id).getAnswers()) {
			System.out.println(val.getAnswer());
		}
		
		return "question.jsp";
	}
	@PostMapping("/{id}")
	public String addAnswer(@Valid @ModelAttribute("newAnswer") Answer answer, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question", service.findQuestion(id));
			return "question.jsp";
		}
		
		Answer ans = service.addAnswer(new Answer(answer.getAnswer()));
		service.addAnswerToQuestion(ans, service.findQuestion(id));
		
		return "redirect:/questions/{id}";
	}

}
