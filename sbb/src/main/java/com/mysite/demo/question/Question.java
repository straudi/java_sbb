package com.mysite.demo.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.demo.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // JPA 가 엔티티로 인식
public class Question {
	@Id // 기본 키로 지정
	/*  
	 * @GeneratedValue : 데이터를 저장할 때 해당 속성에 값을 따로 세팅하지 않아도 1 씩 자동으로 증가하여 저장
	 * strategy: 고유번호를 생성하는 옵션
	 * GenerationType.IDENTITY: 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬 때 사용
	 * */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length=200) //  테이블의 컬럼명과 일치, length 는 컬럼의 길이
	private String subject;
	
	@Column(columnDefinition = "TEXT") // columnDefinition : 컬럼의 속성을 정의할 때 사용
	private String content;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
	
}
