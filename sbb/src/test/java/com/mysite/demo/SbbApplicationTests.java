package com.mysite.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest                           
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무 엇 인 가 요?");
//		q1.setContent("sbb에 대 해 서 알 고 싶 습 니 다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1); // 첫 번 째 질 문 저 장
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
		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
		Question q = qList.get(0);
		assertEquals("sbb가 무 엇 인 가 요?", q.getSubject());
		
		
	}

}
