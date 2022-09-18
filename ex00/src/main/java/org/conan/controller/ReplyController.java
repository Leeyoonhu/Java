package org.conan.controller;

import java.util.List;

import org.conan.domain.ReplyVO;
import org.conan.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/replies")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
	private ReplyService service;
	
//	댓글 작성 Controller
	@PostMapping(value = "/new", /* consumes = "application/json", */ produces = {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info( "ReplyVo : "+ vo);
		int insertCount = service.register(vo);
		
		log.info("Reply INSERT COUNT : " + insertCount);
		return 
		insertCount == 1? 
		new ResponseEntity<String>("success", HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	게시글 댓글 목록

	@GetMapping(value="/pages/{bno}/1", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable ("bno") Long bno){
		log.info("getList > > > >" + bno);
		return new ResponseEntity<List<ReplyVO>>(service.getListByBno(bno), HttpStatus.OK);
	}
	
//	댓글 조회(1개만)
	@GetMapping(value="/{rno}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable ("rno") Long rno){
		log.info("get > > > >" + rno);
		return new ResponseEntity<ReplyVO>(service.get(rno), HttpStatus.OK);
	}
//	PostMan에서 DeleteMapping Test (method = "delete")
	@DeleteMapping(value="/{rno}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		log.info("remove > > > > " + rno);
		return service.remove(rno) == 1 
				? new ResponseEntity<String>("success", HttpStatus.OK) 
				: new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	PostMan에서 put Test (method = "put")
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			value = "/{rno}")
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable ("rno") Long rno){
		vo.setRno(rno);
		log.info("rno : " +rno);
		log.info("modify : "+vo);
		return service.modify(vo) == 1
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
