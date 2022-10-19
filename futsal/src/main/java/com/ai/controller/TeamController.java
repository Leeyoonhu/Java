package com.ai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {
	
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public ModelAndView getTeam() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("team");
		return mav;
	}
}