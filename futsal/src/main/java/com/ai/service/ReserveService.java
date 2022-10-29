package com.ai.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.domain.ReserveDTO;

@Service
public interface ReserveService {
	public ReserveDTO findByNameAndNameAAndTime(@RequestParam("name") String name, @RequestParam("tName1") String tName1, @RequestParam("fTime") String fTime);
	public void insert(ReserveDTO reserve);
}
