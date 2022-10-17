package com.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.service.FieldService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/field")
public class FieldController {
	
	@Autowired
	FieldService service;
	
	@RequestMapping(value = "/test01")
	public String searchTest(@RequestParam String fName) {
		System.out.println(fName);
		return service.selectField(fName);
	}
}
