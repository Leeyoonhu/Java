package org.ai.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ai.domain.MemberVO;
import org.ai.service.MemberService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/members/*")
public class MemberController {
	@Autowired
	MemberService service;
	
	@GetMapping("/join")
	public void getJoin() {
		log.info("join....");
	}
	@PostMapping("/joinProc")
	public String postJoin(MemberVO vo) {
		service.join(vo);
		return "redirect:/board/main";
	}
	
	@GetMapping("/login")
	public void getLogin() {
		log.info("login....");
	}
	
	@PostMapping("/loginProc")
	public String postLogin(MemberVO vo, HttpSession session, RedirectAttributes rttr) {
		log.info("vo : " +vo);
		log.info("service : " + service.login(vo));
		session.setAttribute("userInfo", service.login(vo));
		return "redirect:/board/main";
		
	}
	@RequestMapping("/logout")
	public String postLogout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/board/main";
	}
	
	
}
