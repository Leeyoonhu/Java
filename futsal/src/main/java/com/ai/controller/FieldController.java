package com.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.domain.FieldDTO;
import com.ai.service.FieldService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/field")
public class FieldController {
	
	@Autowired
	FieldService service;
	
	@RequestMapping(value = "/reserve")
//	public void test04 () {
//		
//	}
	public ModelAndView searchTest(@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView();
		FieldDTO field = service.selectField(id);
		mav.addObject("field", field);
		return mav;
	}
}
