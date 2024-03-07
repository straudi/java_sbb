package com.mysite.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // @Controller 애너테이션을 적용하면 MainController 클래스는 스프링부트의 컨트롤러
public class MainController {
	@GetMapping("/sbb") //  @GetMapping 애너테이션은 요청된 URL 과의 매핑
	@ResponseBody // URL 요청에 대한 응답으로 문자열을 리턴하라는 의미
	public String index() {
		return "index";
	}
}
