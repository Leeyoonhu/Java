package org.ai.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletResponse;

import org.ai.service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/comment/*")
public class CommentController {
	@Autowired
	CommentService service;
	
	@PostMapping("/insert")
	public String insert(@Param("number")Integer number, @Param("writer") String writer, @Param("comment") String comment, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		service.insert(number, writer, comment);
		String url = String.format("redirect:../board/view?number=%d",number);
		out.print(url);
		return url;
	}
}
