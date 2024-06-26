package com.mysite.demo.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	/* 메서드 선언하고 구현X 실행되는 이유 : JpaRep ository 를 상속한 QuestionRepository 객체가 생성될 때 (DI 에 의해 스프링이 자동으로 QuestionRepository 객체를 생성한다. 이 때 프록시 패턴이 사용된다고 한다.) 
	 * 리포지터리 객체의 메서드가 실행될 때 JPA가 해당 메서드명을 분석하여 쿼리를 만들고 실행, findBy + 엔티티의 속성명(예:findBySubject) 과 같은 리포지터리 메서드를 작성하면 해당 속성의 값으로 데이터를 조회 가능
	 * */
	Question findBySubject(String subject); // 제목 기준으로 검색 추가할 경우 메서드를 인터페이스에 선언
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
	Page<Question> findAll(Pageable pageable);
	Page<Question> findAll(Specification<Question> spec, Pageable pageable);
	@Query("select "
			+ "distinct q "
			+ "from Question q "
			+ "left outer join SiteUser u1 on q.author=u1 "
			+ "left outer join Answer a on a.question=q "
			+ "left outer join SiteUser u2 on a.author=u2 "
			+ "where "
			+ " q.subject like %:kw% "
			+ " or q.content like %:kw% "
			+ " or u1.username like %:kw% "
			+ " or a.content like %:kw% "
			+ " or u2.username like %:kw% ")
	Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}
