package org.conan.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.conan.domain.SampleDTO;
import org.conan.domain.SampleDTOList;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
//	Model, Controller에서 생성된 data를 담아서 JSP에 전달	data >> controller >> view
	@GetMapping("/ex04")
//	자동 형 변환은 beans에 선언된애들만 되고, 기본형 변수는 불가능
//	beans에는 없는 속성으로 받고싶으면 @ModelAttribute 사용 => @ModelAttribute(key) 자료형 value
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto : " + dto);
		log.info("page : " + page);
		return "./sample/ex04";
//		JSP view file 하고 짝이 지어지게 이름을 지었음(굳이 똑같이 만들필요는 없음)
	}
//	페이지 이동시에 parameter값 넘겨주는 방법 => RedirectAttributes (p143 참고)
	
//	method type 이 void 일 경우는 요청 경로와 동일한 이름의 .jsp가 필요
//	String 일 경우는 상관없음
	@GetMapping("/ex05")
	public void ex05() {
		log.info("너는 어디로 갔을까");
	}
	
//	특별하게 page가 필요없는 ResponseBody
//	SampleDTO 타입 메서드 (반환도 SampleDTO 타입)
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("ex06..........!!!@");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("conan");
		return dto;
	}
	
//	body 와 header를 합친 Entity타입
//	ResponseEntity
//	http protocool의 헤더를 다루는 경우
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("ex07..........");
		String msg = String.format("{\"name\":\"conan\"}");
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json; charset=UTF-8");
		return new ResponseEntity<String>(msg, header, HttpStatus.NOT_FOUND);
	}
}
