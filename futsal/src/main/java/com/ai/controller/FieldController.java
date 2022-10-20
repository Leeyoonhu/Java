package com.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ai.domain.FieldDTO;
import com.ai.service.FieldService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/field")
public class FieldController {
	
	@Autowired
	FieldService service;
	
	@RequestMapping(value = "/click")
	public ModelAndView moveToField(@RequestParam("fName") String fName, RedirectAttributes redirect) {
		ModelAndView mav = new ModelAndView();
		FieldDTO field = service.findByfName(fName);
		System.out.println(Integer.parseInt(field.getId()));
		mav.addObject("id", Integer.parseInt(field.getId()));
		mav.setViewName("redirect:reserve");
		return mav;
	}
	
	
	@RequestMapping(value = "/reserve")
	public ModelAndView searchTest(@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView();
		FieldDTO field = service.findByid(id);
		mav.addObject("field", field);
		return mav;
	}
}
