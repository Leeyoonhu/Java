package com.ai.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
	KaKaoAPI kakaoApi = new KaKaoAPI();
	NaverAPI naverApi = new NaverAPI();
	GoogleAPI googleApi = new GoogleAPI();
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam("code") String code, HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		String access_token = null;
		String state = null;
		String platform = null;
		HashMap<String, Object> userInfo = null;
		Cookie[] cookieArr = request.getCookies();
		for(Cookie cookie : cookieArr) {
			if(cookie.getName().equals("platform")) {
				platform = cookie.getValue();
			}
		}
		
		
		// 카카오 일때
		if(platform.equals("kakao")) {
			access_token = kakaoApi.getAccessToken(code);
			userInfo = kakaoApi.getUserInfo(access_token);
		}
		
		// 네이버 일때
		if(platform.equals("naver")) {
			access_token = naverApi.getAccessToken(code, session);
			state = (String)session.getAttribute("state");
			userInfo = naverApi.getUserInfo(access_token);
		}
		
		// 구글 일때
		if(platform.equals("google")) {
			access_token = googleApi.getAccessToken(code);
			userInfo = googleApi.getUserInfo(access_token);
		}
		
		if(userInfo.get("email") != null) {
			session.setAttribute("userId", userInfo.get("email"));
			session.setAttribute("access_token", access_token);
		}
		
		System.out.println("login platform : " + platform);
		System.out.println("access_token : " + access_token);
		System.out.println("login info : " + userInfo.toString());
		mav.addObject("userId", userInfo.get("email"));
		// 메인페이지 위치로
		mav.setViewName("test01");
		return mav;
	}
}
