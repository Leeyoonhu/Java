package com.ai.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.domain.ReserveDTO;

@Service
public interface ReserveService {
	public ReserveDTO findByFieldAndNameAAndTime(@RequestParam("name") String name, @RequestParam("tName1") String tName1, @RequestParam("fTime") String fTime);
	public void insert(ReserveDTO reserve);
	public ArrayList<ReserveDTO> findByField(String name);
}
