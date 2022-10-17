package com.ai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommunityController {
	@RequestMapping(value = "community")
	public ModelAndView getCommunity() {
		return new ModelAndView("community");
	}
}
