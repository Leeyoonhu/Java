package org.conan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

// 컨트롤러에게 가장 먼저 annotation 해야할 부분은 무슨 역할인지 
@Controller
@RequestMapping("/sample/*")
@Log4j
// 무조건 주소창에 sample을 거치면 이 컨트롤러가 request하겠다고 선언
// p127에서 설명
public class SampleController {
	
//	log 를 사용하려면 @Log4j 필요
	@RequestMapping("")
	public void basic() {
		log.info("basic.................");
	}
}
