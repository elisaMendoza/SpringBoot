package com.elisa.dojoverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.elisa.dojoverflow.models.Answer;
import com.elisa.dojoverflow.models.Question;
import com.elisa.dojoverflow.models.Tag;
import com.elisa.dojoverflow.repos.AnswerRepository;
import com.elisa.dojoverflow.repos.QuestionRepository;
import com.elisa.dojoverflow.repos.TagRepository;

@Service
public class DojoService {
	private QuestionRepository questionRepo;
	private TagRepository tagRepo;
	private AnswerRepository answerRepo;
	
	public DojoService (QuestionRepository questionRepo, TagRepository tagRepo, AnswerRepository answerRepo) {
		this.questionRepo = questionRepo;
		this.tagRepo = tagRepo;
		this.answerRepo = answerRepo;
	}
	
	public List<Question> allQuestions() {
		return (List<Question>) questionRepo.findAll();
	}
	public List<Tag> allTags() {
		return (List<Tag>) tagRepo.findAll();
	}
	public List<String> allTagNames() {
		List<String> result = new ArrayList<>();
		for(Tag val:tagRepo.findAll()) {
			result.add(val.getSubject());
		}
		return result;
	}
	public Question addQuestion(Question question) {
		return questionRepo.save(question);
	}
	public Tag addTag(Tag tag) {
		return tagRepo.save(tag);
	}
	public void addQuestionTag(Question question, Tag tag) {
		question.getTags().add(tag);
		questionRepo.save(question);
		tagRepo.save(tag);
	}
	public Tag findTagByName(String tag) {
		for(Tag val:tagRepo.findAll()) {
			if(val.getSubject().equals(tag)) {
				return val;
			} 
		}
		return null;
	}
	public Answer addAnswer(Answer answer) {
		return answerRepo.save(answer);
	
	}
	public void addAnswerToQuestion(Answer answer, Question question) {
		answer.setQuestion(question);
		answerRepo.save(answer);

	}
	public Question findQuestion(Long id) {
	    Optional<Question> temp = questionRepo.findById(id);
        if(temp.isPresent()) {
            return temp.get();
        } else {
            return null;
        }
    }
	public List<Answer> findAnswer() {
		return (List<Answer>) answerRepo.findAll();
	}

}
