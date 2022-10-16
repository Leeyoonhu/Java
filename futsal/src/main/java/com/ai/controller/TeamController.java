package com.ai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/team/*")
public class TeamController {
	
	@RequestMapping(value = "/" ,method = RequestMethod.GET)
	public ModelAndView getTeam() {
		ModelAndView mav = new ModelAndView();
		System.out.println("hello");
		mav.setViewName("team");
		return mav;
	}
}
