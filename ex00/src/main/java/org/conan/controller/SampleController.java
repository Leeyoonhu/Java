package org.conan.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.conan.domain.SampleDTO;
import org.conan.domain.SampleDTOList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
//	루트(/)에서 /sample/basic일때 호출
	@RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get.................!!!!");
	}
//			/sample/basicOnlyget일때 호출
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic Only Get!!!!!!!!!!!!!!!");
	}
	
	@GetMapping("/ex01")
//	해당 mapping 조건일때 query문에서 받은 k-v 를 dto 객체에 전달
//	Integer로 형변환 필요없음. 자동 형 변환 지원
	public String ex01(SampleDTO dto) {
		log.info(""+ dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
	}
//	리스트, 배열 처리
//	query문에서 ids에 여러 값을 전송했을 시 리스트값에 add후 출력
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[]ids) {
		log.info("array ids : " + Arrays.toString(ids));
		return "ex02Array";
	}
//	객체 리스트(SampleDTOList)
//	리스트이기때문에 query문에서 index를 부여해줘야하는데 [1] ==> %5B 1 %5D ([ = %5B / ] = %5D) 
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList sdList) {
		log.info("sdList dtos : " + sdList);
		return "ex02Bean";
	}
	
}
