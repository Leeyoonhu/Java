package org.ai.controller;

import javax.servlet.http.HttpSession;

import org.ai.domain.BoardVO;
import org.ai.service.BoardService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	@GetMapping("/myArticle")
	public void getMyArticle(Model model, String nickName) {
		model.addAttribute("bList", service.getMyArticle(nickName));
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
	public String writeBoard (@Param("writer") String writer, @Param("title") String title, @Param("content") String content, 
			@Param("imageFileName") MultipartFile File, @Param("boardTitle") String boardTitle, Model model, HttpSession session, RedirectAttributes rttr) {
		String imageFileName = null;
		String imageFilePath = null;
		if(File.isEmpty()) {
			
		}
		else {
			imageFileName = File.getOriginalFilename();
			
		}
		
		BoardVO vo = new BoardVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setBoardTitle(boardTitle);
		vo.setImageFileName(imageFileName);
		vo.setImageFilePath(imageFilePath);
		service.write(vo);
		return "redirect: ../board/" + (String)session.getAttribute("boardTitle");
	}
	
	@PostMapping("/search")
	public void search(@Param("title")String title, @Param("content")String content, Model model) {
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
