package com.mysite.demo.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.demo.question.Question;
import com.mysite.demo.question.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, 
			@Valid AnswerForm answerForm, BindingResult bindingResult) {
			//@RequestParam String content) {
		Question question = this.questionService.getQuestion(id);
		if(bindingResult.hasErrors()) {
			model.addAttribute("question", question);
			return "question_detail";
		}
		this.answerService.create(question, answerForm.getContent());
		// todo : 답변을 저장한다.
		return String.format("redirect:/question/detail/%s", id);
	}
}
