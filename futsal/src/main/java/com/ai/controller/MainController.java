package com.ai.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.domain.FieldDTO;
import com.ai.service.FieldService;

@Controller
public class MainController {
	KaKaoAPI kakaoApi = new KaKaoAPI();
	NaverAPI naverApi = new NaverAPI();
	GoogleAPI googleApi = new GoogleAPI();
	
	@Autowired
	FieldService fService;
	
//	TEST CALENDER 
	@RequestMapping(value = "/cal")
	public void test01() {
	
	}
//	TEST CREATE TEAM
	@RequestMapping(value ="/createTeam")
	public void test02() {
		
	}
//	TEST FIELD RESERVE
	@RequestMapping(value ="/reserve")
	public void test03() {
		
	}
	
	
	@RequestMapping(value = "/login")
	public ModelAndView getLogin() throws UnsupportedEncodingException {
		// https://developers.naver.com/docs/login/api/api.md 참조
		ModelAndView mav = new ModelAndView();
		String clientId = "s3SKlARx4M5gtCyBNSwG";//애플리케이션 클라이언트 아이디값";
		// callbackURL 나중에 변경할것
	    String redirectURI = URLEncoder.encode("http://localhost:8080/loginAccess", "UTF-8");
	    SecureRandom random = new SecureRandom();
	    // state 는 Naver 사에서 'CSRF를 방지하기 위한 인증값입니다. 임의의 값을 넣어 진행해주시면 되는데요.' 라고 답변 (난수 입력)
	    String state = new BigInteger(130, random).toString();
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    System.out.println(apiURL);
	    mav.addObject("apiURL", apiURL);
	    mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value = "/loginAccess")
	public ModelAndView login(@RequestParam("code") String code, HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		System.out.println("code : " + code);
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
		session.setAttribute("userId", userInfo.get("email"));
		// 메인페이지 위치로
		mav.setViewName("redirect:main");
		return mav;
	}
	
	@RequestMapping(value = "/") 
	public String goMain() {
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView getMain(HttpSession session, Model model) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		ArrayList<FieldDTO> fList = fService.findAll();
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
	    mav.setViewName("main");
	    return mav;
	}
	
	// 유저 로그아웃
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mav = new ModelAndView();
			String platform = null;
			Cookie[] cookieArr = request.getCookies();
			for(Cookie cookie : cookieArr) {
				if(cookie.getName().equals("platform")) {
					platform = cookie.getValue();
				}
			}
			if(platform.equals("kakao")) {
				kakaoApi.logout((String)session.getAttribute("access_token"));
			}
			if(platform.equals("naver")) {
				naverApi.logout((String)session.getAttribute("access_token"));
			}
			if(platform.equals("google")) {
				googleApi.logout((String)session.getAttribute("access_token"));
			}

			// 세션 다죽임
			session.invalidate();
			// 쿠키도 죽임
			for(Cookie cookie : cookieArr) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			// 메인 페이지 위치로
			mav.setViewName("redirect:main");
			
			return mav;
		}
}
