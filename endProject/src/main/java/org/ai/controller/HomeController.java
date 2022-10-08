package org.ai.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
public class HomeController {
	KaKaoAPI kakaoApi = new KaKaoAPI();
	NaverAPI naverApi = new NaverAPI();
	GoogleAPI googleApi = new GoogleAPI();
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLogin(HttpSession session, Model model) throws UnsupportedEncodingException {
		// https://developers.naver.com/docs/login/api/api.md 참조
		// 로그인 페이지시 네이버 버튼을 누르기 위해 필요한 정보
		String clientId = "s3SKlARx4M5gtCyBNSwG";//애플리케이션 클라이언트 아이디값";
		// callbackURL 나중에 변경할것
	    String redirectURI = URLEncoder.encode("http://localhost:8080/login", "UTF-8");
	    SecureRandom random = new SecureRandom();
	    // state 는 Naver 사에서 'CSRF를 방지하기 위한 인증값입니다. 임의의 값을 넣어 진행해주시면 되는데요.' 라고 답변 (난수 입력)
	    String state = new BigInteger(130, random).toString();
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    session.setAttribute("state", state);
	    model.addAttribute("apiURL", apiURL);
		return "login";
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
