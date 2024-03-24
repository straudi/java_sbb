package com.mysite.demo.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class QuestionController {
	//private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
	@GetMapping("/question/list")
	//@ResponseBody
	public String list(Model model) {
		//List<Question> questionList = this.questionRepository.findAll();
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
}
