package com.ai.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping(path = "/{id}")
	public ModelAndView searchField(@PathVariable String id, HttpServletRequest request, HttpServletResponse response, ModelAndView mav2) throws IOException {
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
		LinkedHashMap <String, String> timeMap = new LinkedHashMap <String, String>();
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("date")) {
				date = cookie.getValue();
				System.out.println("현재 선택된 날짜 : " + date);
			}
		}
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
//		int hours = cal.HOUR;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(today);
		System.out.println("now : " + now);
		
		for(int j = 0; j < 12; j++) {
			timeMap.put(String.format("%d - %d", 2*j, (2*j)+2), "null");
		} 
		String[] timeArray = timeMap.keySet().toArray(new String[timeMap.size()]);
		String[] timeArray2 = new String[24];
//		System.out.println("HOURS : " + hours);
//		for(int p = 0; p < timeArray.length; p++) {
//			timeArray2 = timeArray[p].split(" , ");
//		}
//		for(int t = 0; t < timeArray2.length; t++) {
//			
//		}
		try {
			reserveList = rService.findByField(field.getfName());
			for(int i = 0; i < reserveList.size(); i++) {
				System.out.println(i + "번째 reserveList의 getDate : " + reserveList.get(i).getDate());
				if(reserveList.get(i).getDate().equals(date)) {
					try {
						if(reserveList.get(i).getType().equals("part")) {
							timeMap.replace(reserveList.get(i).getTime(), reserveList.get(i).getState());
						}
						if(reserveList.get(i).getType().equals("All") || reserveList.get(i).getState().equals("B")) {
							timeMap.replace(reserveList.get(i).getTime(), "full");
						}
					} catch (Exception e) {
						System.out.println("Field Controller Error : " + e.getMessage());
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("해당 구장의 예약 정보가 없음!");
		}
		if(now.equals(date)) {
//			for(int z = 0; z < timeArray.length; z+=2) {
//				if(hours >= Integer.parseInt(timeArray[z])) {
//					
//				}
//			}
		}
		System.out.println("예약 리스트(reserveList) 정보 : " + reserveList);
//		System.out.println("시간 테이블의 정보 : " + timeMap.keySet());
		
		
		for(int k = 0; k < timeMap.size(); k++) {
//			System.out.println(k + "번째 타임 리스트(timeMap) 정보 : " + timeMap.get(String.format("%d - %d", 2*k, (2*k)+2)));
		}
		
		mav.clear();
		mav.addObject("timeMap", timeMap);
		mav.addObject("fNList", fNList);
		mav.addObject("latList", latList);
		mav.addObject("lonList", lonList);	
		mav.addObject("field", field);
		mav.setViewName("/field");
		return mav;
	}
}
