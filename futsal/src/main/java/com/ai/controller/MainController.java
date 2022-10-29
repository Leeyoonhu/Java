package com.ai.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.domain.FieldDTO;
import com.ai.domain.GoogleAPI;
import com.ai.domain.KaKaoAPI;
import com.ai.domain.MemberDTO;
import com.ai.domain.NaverAPI;
import com.ai.domain.TeamDTO;
import com.ai.service.FieldService;
import com.ai.service.MemberService;
import com.ai.service.TeamService;

@Controller
public class MainController {
	KaKaoAPI kakaoApi = new KaKaoAPI();
	NaverAPI naverApi = new NaverAPI();
	GoogleAPI googleApi = new GoogleAPI();
	@Autowired
	FieldService fService;

	@Autowired
	MemberService mService;

	@Autowired
	TeamService tService;

	@RequestMapping(value = "/teamtables", method = RequestMethod.GET)
	public ModelAndView goTeam(HttpSession session) {
		// TEST CODE
		System.out.println("=============== Sesssion ==============");
		System.out.println("세션 유저 아이디 : " + session.getAttribute("userId"));
		System.out.println("=============== Sesssion ==============");
		System.out.println("=============== RESERVE MAV ===================");
		System.out.println("member : " + mService.findBy_id((String)session.getAttribute("userId")));
		System.out.println("team : " + tService.findBytName(mService.findBy_id((String)session.getAttribute("userId")).getTName()));
		System.out.println("=============== RESERVE MAV ===================");
		// END TEST
		ModelAndView mav = new ModelAndView();
		mav.addObject("team", tService.findBytName(mService.findBy_id((String)session.getAttribute("userId")).getTName()));
		String _id = (String) (session.getAttribute("userId"));
		MemberDTO member = new MemberDTO();
		member = mService.findBy_id(_id);
		mav.addObject("member", member);
		TeamDTO myTeam = tService.findBytName(member.getTName());
		mav.addObject("myTeam", myTeam);
		ArrayList<TeamDTO> tList = tService.findAll();
		mav.addObject("tList", tList);
		mav.setViewName("/teamtables");
		return mav;
	}

	// TEST
	@RequestMapping(value = "/login")
	public ModelAndView getLogin() throws Exception {
		ModelAndView mav = new ModelAndView();
		String clientId = "s3SKlARx4M5gtCyBNSwG";// 애플리케이션 클라이언트 아이디값";
		// callbackURL 나중에 변경할것
		String redirectURI = URLEncoder.encode("http://localhost:8080/loginAccess", "UTF-8");
		SecureRandom random = new SecureRandom();
		// state 는 Naver 사에서 'CSRF를 방지하기 위한 인증값입니다. 임의의 값을 넣어 진행해주시면 되는데요.' 라고 답변 (난수
		// 입력)
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state;
		mav.addObject("apiURL", apiURL);
		mav.setViewName("/login");
		return mav;
	}

	@RequestMapping(value = "/register")
	public ModelAndView getRegister() throws UnsupportedEncodingException {
		// https://developers.naver.com/docs/login/api/api.md 참조
		ModelAndView mav = new ModelAndView();
		String clientId = "s3SKlARx4M5gtCyBNSwG";// 애플리케이션 클라이언트 아이디값";
		// callbackURL 나중에 변경할것
		String redirectURI = URLEncoder.encode("http://localhost:8080/loginAccess", "UTF-8");
		SecureRandom random = new SecureRandom();
		// state 는 Naver 사에서 'CSRF를 방지하기 위한 인증값입니다. 임의의 값을 넣어 진행해주시면 되는데요.' 라고 답변 (난수
		// 입력)
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state;
		mav.addObject("apiURL", apiURL);
		mav.setViewName("/register");
		return mav;
	}

	@RequestMapping(value = "/loginAccess")
	public ModelAndView login(@RequestParam("code") String code, HttpSession session, HttpServletRequest request)
			throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		System.out.println("code : " + code);
		String access_token = null;
		String state = null;
		String platform = null;
		String name = null;
		String nickName = null;
		String sex = null;
		String phoneNo = null;
		String tName = "null";
		int hadPoint = 0;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(date);
		MemberDTO member = new MemberDTO();

		HashMap<String, Object> userInfo = null;
		Cookie[] cookieArr = request.getCookies();
		for (Cookie cookie : cookieArr) {
			if (cookie.getName().equals("platform")) {
				platform = cookie.getValue();
			}
			if (cookie.getName().equals("name")) {
				name = cookie.getValue();
				System.out.println("Cookie name : " + name);
			}
			if (cookie.getName().equals("nickName")) {
				nickName = cookie.getValue();
				System.out.println("Cookie nickName : " + nickName);
			}
			if (cookie.getName().equals("sex")) {
				sex = cookie.getValue();
				System.out.println("Cookie sex : " + sex);
			}
			if (cookie.getName().equals("phoneNo")) {
				phoneNo = cookie.getValue();
				System.out.println("Cookie phoneNo : " + phoneNo);
			}
		}

		// 카카오 일때
		if (platform.equals("kakao")) {
			access_token = kakaoApi.getAccessToken(code);
			userInfo = kakaoApi.getUserInfo(access_token);
		}

		// 네이버 일때
		if (platform.equals("naver")) {
			access_token = naverApi.getAccessToken(code, session);
			state = (String) session.getAttribute("state");
			userInfo = naverApi.getUserInfo(access_token);
		}

		// 구글 일때
		if (platform.equals("google")) {
			access_token = googleApi.getAccessToken(code);
			userInfo = googleApi.getUserInfo(access_token);
		}

		if (userInfo.get("email") != null) {
			session.setAttribute("userId", userInfo.get("email"));
			session.setAttribute("access_token", access_token);
		}
		// 메인페이지 위치로
		if (name != null) {
			member.set_id((String) userInfo.get("email"));
			member.setPlatform(platform);
			member.setRegDate(now);
			member.setName(name);
			member.setNickName(nickName);
			member.setSex(sex);
			member.setPhoneNo(phoneNo);
			member.setTName(tName);
			member.setHadPoint(hadPoint);
			mService.insert(member);
		}
		System.out.println("login platform : " + platform);
		System.out.println("access_token : " + access_token);
		System.out.println("login info : " + userInfo.toString());
		session.setAttribute("userId", userInfo.get("email"));
		mav.setViewName("redirect:/main");
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
		for (int i = 0; i < fList.size(); i++) {
			fNList.add(fList.get(i).getfName());
			latList.add(fList.get(i).getLatitude());
			lonList.add(fList.get(i).getLongitude());
		}
		mav.addObject("fNList", fNList);
		mav.addObject("latList", latList);
		mav.addObject("lonList", lonList);
		mav.setViewName("/main");
		return mav;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String platform = null;
		Cookie[] cookieArr = request.getCookies();
		for (Cookie cookie : cookieArr) {
			if (cookie.getName().equals("platform")) {
				platform = cookie.getValue();
			}
		}
		try {
			if (platform.equals("kakao")) {
				kakaoApi.logout((String) session.getAttribute("access_token"));
				session.invalidate();
			}
			if (platform.equals("naver")) {
				naverApi.logout((String) session.getAttribute("access_token"));
				session.invalidate();
			}
			if (platform.equals("google")) {
				googleApi.logout((String) session.getAttribute("access_token"));
				session.invalidate();
			}
		} catch (Exception e) {
			session.invalidate();
		}

		for (Cookie cookie : cookieArr) {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		mav.setViewName("redirect:/main");
		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	   public ModelAndView searchFields(@RequestParam("fName") String fName) {
	      ModelAndView mav = new ModelAndView();
	      ArrayList<FieldDTO> fields = fService.findByFNameRegex(fName);
	      mav.addObject("fields", fields);
	      mav.setViewName("/search");
	      ArrayList<FieldDTO> fList = fService.findAll();
	      ArrayList<String> fNList = new ArrayList<String>();
	      ArrayList<String> latList = new ArrayList<String>();
	      ArrayList<String> lonList = new ArrayList<String>();
	      for (int i = 0; i < fList.size(); i++) {
	         fNList.add(fList.get(i).getfName());
	         latList.add(fList.get(i).getLatitude());
	         lonList.add(fList.get(i).getLongitude());
	      }
	      mav.addObject("fNList", fNList);
	      mav.addObject("latList", latList);
	      mav.addObject("lonList", lonList);
	      return mav;
	   }
	
	@RequestMapping(value = "/reserve/{selectField}")
	public ModelAndView goReserve(@PathVariable("selectField") String selectField, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", mService.findBy_id((String)session.getAttribute("userId"))); 
		mav.addObject("team", tService.findBytName(mService.findBy_id((String)session.getAttribute("userId")).getTName()));
		Cookie[] cookies = request.getCookies();
		FieldDTO field = fService.findByfName(selectField);
		for (Cookie cookie : cookies) {
			System.out.println("쿠키 이름 : " + cookie.getName());
			if (cookie.getName().equals("date")) {
				mav.addObject("date", cookie.getValue());
			}
		}
		mav.addObject("selectField", field);
		// TEST CODE
		System.out.println("=================== Sesssion ==================");
		System.out.println("세션 유저 아이디 : " + session.getAttribute("userId"));
		System.out.println("=================== Sesssion ==================");
		System.out.println();
		System.out.println("=============== Reserve Model Objects ===================");
		System.out.println("member : " + mService.findBy_id((String)session.getAttribute("userId")));
		System.out.println("team : " + tService.findBytName(mService.findBy_id((String)session.getAttribute("userId")).getTName()));
		System.out.println("현재 선택된 필드 : " + field);
		System.out.println("=============== Reserve Model Objects ===================");
		// END TEST
		mav.setViewName("/reserve");
		return mav;
	}
}