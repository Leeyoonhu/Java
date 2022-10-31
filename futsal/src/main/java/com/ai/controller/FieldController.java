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
import com.ai.domain.ReserveDTO;
import com.ai.service.FieldService;
import com.ai.service.ReserveService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/field")
public class FieldController {
	@Autowired
	FieldService service;
	
	@Autowired
	ReserveService rService;
	
	@RequestMapping(value = "/click")
	public String moveToField(@RequestParam("fName") String fName) { 
		FieldDTO field = service.findByfName(fName);
		return "redirect:/field/"+field.getId();
	}
	
	@RequestMapping("/{id}")
	public ModelAndView searchTest(@PathVariable String id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		FieldDTO field = service.findByid(id);
		ArrayList<FieldDTO> fList = service.findAll();
		ArrayList<String> fNList = new ArrayList<String>();
		ArrayList<String> latList = new ArrayList<String>(); 
		ArrayList<String> lonList = new ArrayList<String>();
		ArrayList<ReserveDTO> reserveList = new ArrayList<ReserveDTO>();
		for(int i = 0; i < fList.size(); i++) {
			fNList.add(fList.get(i).getfName());
			latList.add(fList.get(i).getLatitude());
			lonList.add(fList.get(i).getLongitude());
		}
		String date = null;
		ArrayList <String> timeList = new ArrayList <String>();
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("date")) {
				date = cookie.getValue();
				System.out.println("현재 선택된 날짜 : " + date);
			}
		}
		
//		try {
			reserveList = rService.findByField(field.getfName());
			for(int i = 0; i < reserveList.size(); i++) {
				if(reserveList.get(i).getDate() == date) {
					try {
						if(reserveList.get(i).getTime() != null) {
							timeList.add(reserveList.get(i).getTime());
						} else {
							timeList.add("null");
						}
					} catch (Exception e) {
						timeList.add("null");
					}
					// 시간 목록 판별 조건 보여줘야함
				}
			}
//		} catch (Exception e) {
//			System.out.println("해당 구장의 예약 정보가 없음!");
//		}
			System.out.println("예약 리스트 정보 : " + reserveList);
		for(int i = 0; i < timeList.size(); i++) {
			System.out.println(timeList.get(i).toString());
		}
		
		mav.addObject("fNList", fNList);
		mav.addObject("latList", latList);
		mav.addObject("lonList", lonList);	
		mav.addObject("field", field);
		mav.setViewName("/field");
		return mav;
	}
}
