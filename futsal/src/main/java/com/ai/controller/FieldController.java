package com.ai.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/click")
	public String moveToField(@RequestParam("fName") String fName, HttpServletRequest request) { 
		FieldDTO field = service.findByfName(fName);
		Cookie[] cookies = request.getCookies();
		String year = null;
		String month = null;
		String day = null;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("year")) {
				year = cookie.getValue();
			}
			if(cookie.getName().equals("month")) {
				month = cookie.getValue();
			}
			if(cookie.getName().equals("day")) {
				day = cookie.getValue();
			}
		}
		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("day : " + day);
		System.out.println(Integer.parseInt(field.getId()));
		return "redirect:/field/reserve/"+field.getId();
	}
	
	@RequestMapping("/reserve/{id}")
	public ModelAndView searchTest(@PathVariable String id) {
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
		mav.setViewName("/field/reserve");
		return mav;
	}
}
