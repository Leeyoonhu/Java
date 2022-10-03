package org.ai.controller;

import org.ai.service.KaKaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private KaKaoService kakao;
	
	// 카카오 로그인 테스트용 
	@RequestMapping(value = "kakaoLogin", method=RequestMethod.GET)
	public String kakaoLogin(@RequestParam(value="code", required = false) String code) {
		System.out.println("Test Code : " + code);
		
		//  토큰 code
		String access_Token = kakao.getAccessToken(code);
		System.out.println("가져온 token : " + access_Token);
		
		return "member/testPage";
	}
}
