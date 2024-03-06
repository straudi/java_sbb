package com.mysite.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("/hello")
	@ResponseBody // 메서드의 응답 결과가 문자열
	public String hello() {
		return "Hello Spring Boot1";
	}
}
