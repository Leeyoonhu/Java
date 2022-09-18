package org.conan.controller;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.conan.domain.SampleVO;
import org.conan.domain.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/rsample")
@Log4j
@AllArgsConstructor
public class RSampleController {
	@GetMapping(value = "/getText", produces = "text/plain; charset=utf-8")
	public String getText() {
		log.info("MIME TYPE: "+ MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
//	JSON 값과 XML값, /rsample/getSample.json과 /rsample/getSample
	@GetMapping(value="/getSample", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	@GetMapping(value="/getList")
	public List<SampleVO> getList() {
		return IntStream.range(1,10).mapToObj(i-> new SampleVO(i, i+" first", i+" last")).collect(Collectors.toList());
	}
//	맵으로 받는거 해보기(p364)
	
	@GetMapping(value="/check", params= {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO svo = new SampleVO(000, ""+height, ""+weight);
		ResponseEntity<SampleVO> result = null;
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(svo);
//			height이 150보다 작을경우, 502 error 
		}
		else {
			result = ResponseEntity.status(HttpStatus.OK).body(svo);
		}
		return result;
	}
//	URL 경로 중간에 들어간 값을 얻기위해서 사용
//	params처럼 ?k=v&k=v... 이런식이아님
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(
		@PathVariable("cat") String cat,
		@PathVariable("pid") Integer pid) {
		return new String[] {"category: " + cat, "productid: " + pid};
	}
	
//	JSON데이터를 Object 타입으로 변경하는 객체 @RequestBody
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert........ticket"+ticket);
		return ticket;
	}
}
