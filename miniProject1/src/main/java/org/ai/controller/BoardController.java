package org.ai.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ai.domain.BoardVO;
import org.ai.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BoardService service;
	
	@GetMapping("/main")
	public void getMain() {
		log.info("check main");
	}
	
	@GetMapping("/write")
	public void getBoardWrite() {
		log.info("write");
	}
	
	@GetMapping("/free")
	public void getFree(Model model, HttpSession session, RedirectAttributes rttr) {
		log.info("free.......");
		session.setAttribute("boardTitle", "free");
		model.addAttribute("bList", service.getList("free"));
	}
	@GetMapping("/question")
	public void getQuestion(Model model, HttpSession session, RedirectAttributes rttr) {
		log.info("question");
		session.setAttribute("boardTitle", "question");
		model.addAttribute("bList", service.getList("question"));
	}
	@GetMapping("/info")
	public void getInfo(Model model, HttpSession session, RedirectAttributes rttr) {
		log.info("info");
		session.setAttribute("boardTitle", "info");
		model.addAttribute("bList", service.getList("info"));
	}
	@GetMapping("/screen")
	public void getScreen(Model model, HttpSession session, RedirectAttributes rttr) {
		log.info("screen............ ");
		session.setAttribute("boardTitle", "screen");
		model.addAttribute("bList", service.getList("screen"));
	}
	@GetMapping("/calendar")
	public void getCalendar() {
		log.info("calendar");
	}
	
	@GetMapping("/notice")
	public void getNotice(Model model) {
		log.info("notice");
		model.addAttribute("bList", service.getNoticeList());
	}
	@GetMapping("/current")
	public void getCurrentList(Model model) {
		log.info("current");
		model.addAttribute("bList", service.getCurrentList());
	}
	@GetMapping("/popular")
	public void getPopular(Model model) {
		log.info("popular");
		model.addAttribute("bList", service.getPopularList());
	}

	// 글쓰기 보류
	@PostMapping("/writeProc")
	public String writeBoard (BoardVO vo, HttpSession session, RedirectAttributes rttr) {
		service.write(vo);
		String boardTitle = (String)session.getAttribute("boardTitle");
		return "redirect: ../board/" + boardTitle;
	}
	
	@GetMapping("/search")
	public void search(@RequestParam("searchTitle")String title, @RequestParam("content")String content, Model model) {
		model.addAttribute("bList", service.search(title, content));
	}
	
	@GetMapping("/view")
	public void getBoardView(@RequestParam("number") int number, Model model){
		log.info("getList > > > >" + number);
		service.plusView(number);
		model.addAttribute("bList", service.getBoardView(number));
	}
	
	@PostMapping("plusreco")
	public String plusReco(Integer number) {
		service.plusReco(number);
		return "redirect: ../board/view?number=" + number;
	}
	//======================================REMOVEME
	@GetMapping("/test")
	public void getTest() {
		log.info("check main");
	}
	
	
}
