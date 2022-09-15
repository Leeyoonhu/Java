package org.conan.controller;

import org.conan.domain.BoardVO;
import org.conan.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")

// 게시물(BoardVO)의 목록을 Model에 담아서 전달
public class BoardController {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
//	/board/register일때
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
//		redirect ==> response.sendRedirect()
		log.info("register : " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
//		
		return "redirect:/board/list";
	}
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get");
		model.addAttribute("board", service.get(bno));
	}
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify : " +board);
		if(service.modify(board)) {
//			수정되었다면
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("삭제할 북 넘버 : " + bno);
		if(service.remove(bno)) {
//			삭제가 되었다면
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/remove";
	}
}
