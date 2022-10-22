package com.ai.controller;

import java.util.ArrayList;

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
		ArrayList<FieldDTO> fList = service.findAll();
		ArrayList<String> fNList = new ArrayList<String>();
		ArrayList<String> latList = new ArrayList<String>(); 
		ArrayList<String> lonList = new ArrayList<String>();
		for(int i = 0; i < fList.size(); i++) {
			fNList.add(fList.get(i).getfName());
			latList.add(fList.get(i).getLatitude());
			lonList.add(fList.get(i).getLongitude());
		}
		mav.addObject("fNList", fNList);
		mav.addObject("latList", latList);
		mav.addObject("lonList", lonList);	
		mav.addObject("field", field);
		return mav;
	}
	
	@RequestMapping(value = "/searchField", method=RequestMethod.POST)
	public ModelAndView searchField(@RequestParam("fName") String fName) {
		ModelAndView mav = new ModelAndView();
		FieldDTO field = service.findByfName(fName);
		mav.addObject("searchedField", field);
		System.out.println(field.getfAddress());
		mav.setViewName("/searchField");
		return mav;
	}
}
