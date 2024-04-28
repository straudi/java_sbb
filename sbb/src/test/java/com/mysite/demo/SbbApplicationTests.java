package com.mysite.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.demo.answer.Answer;
import com.mysite.demo.answer.AnswerRepository;
import com.mysite.demo.question.Question;
import com.mysite.demo.question.QuestionRepository;
import com.mysite.demo.question.QuestionService;

import jakarta.transaction.Transactional;

@SpringBootTest                           
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionService questionService;
	/*
	 * 테스트 코드를 수행할 때 Question 리포지터리가 findById 를 호출하여 Question 객체를 조회하고 나면 DB 세션이 끊어
		지기 때문 그 이후에 실행되는 q.getAnswerList() 메서드는 세션이 종료되어 오류가 발생
		위와 같은 오류를 방지할 수 있는 가장 간단한 방법은 다음처럼 @Transactional 애너테이션을 사용 
	 * */
	@Transactional //
	@Test
	void testJpa() {
		// 질문 생성
		Question q1 = new Question();
		q1.setSubject("선재가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1); // 첫 번 째 질 문 저 장
//		
//		Question q2 = new Question();
//		q2.setSubject("스 프 링 부 트 모 델 질 문 입 니 다.");
//		q2.setContent("id는 자 동 으 로 생 성 되 나 요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2); // 두 번 째 질 문 저 장
		
		// findAll
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//		
//		Question q = all.get(0);
//		assertEquals("sbb가 무 엇 인 가 요?", q.getSubject());
		
		// findById
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 무 엇 인 가 요?", q.getSubject());
//		}
		
		// findBySubject
//		Question q = this.questionRepository.findBySubject("sbb가 무 엇 인 가 요?");
//		assertEquals(1, q.getId());
		
		// findBySubjectAndContent
//		Question q = this.questionRepository.findBySubjectAndContent(
//				"sbb가 무 엇 인 가 요?", "sbb에 대 해 서 알 고 싶 습 니 다.");
//		assertEquals(1, q.getId());
		
		// findBySubjectLike
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb가 무 엇 인 가 요?", q.getSubject());
		
		// 데이터 수정
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
		
		// 데이터 삭제
//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());
		
		// 답변 생성
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
		
		// 답변 조회
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());
//		
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		List<Answer> answerList = q.getAnswerList();
//		
//		assertEquals(1, answerList.size());
//		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
		for (int i = 1; i <= 300; i++) {
			 String subject = String.format("테스트 데이터입니다:[%03d]", i);
			 String content = "내용무";
			 this.questionService.create(subject, content);
		}
	}

}
