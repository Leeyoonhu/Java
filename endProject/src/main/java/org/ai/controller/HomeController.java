package org.ai.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
public class HomeController {
	
	KaKaoAPI kakaoApi = new KaKaoAPI();
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam("code") String code, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// 1. 토큰 요청
		String access_token = kakaoApi.getAccessToken(code);
		// 토큰 오고있니?
		System.out.println("access_token : " + access_token);
		// 2. 토큰으로 유저정보
		HashMap<String, Object> userInfo = kakaoApi.getUserInfo(access_token);
		
		// 코드는 받았니?
		System.out.println("code : " + code);
		// 유저 정보 확인용(나중에 지울것)
		System.out.println("login info : " + userInfo.toString());
		
		// 받은 유저정보에 이메일이 있을경우 세션에 아이디와, 토큰 저장
		if(userInfo.get("email") != null) {
			session.setAttribute("userId", userInfo.get("email"));
			session.setAttribute("access_token", access_token);
		}
		mav.addObject("userId", userInfo.get("email"));
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String KakaoLogin() {
		
		return "login";
	}
	
	// 유저 로그아웃
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		kakaoApi.kakaoLogOut((String)session.getAttribute("access_token"));
		// 접속한 유저 토큰과, 아이디 삭제
		session.removeAttribute("accessToken");
		session.removeAttribute("userId");
		mav.setViewName("index");
		
		return mav;
	}
	
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	
}
