package com.ai.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.domain.ReserveDTO;

@Service
public interface ReserveService {
	public ReserveDTO findReserveToA(@RequestParam("name") String name, @RequestParam("tName1") String tName1, @RequestParam("fDate") String fDate, @RequestParam("fTime") String fTime);
	public ReserveDTO findReserve(@RequestParam("name") String name, @RequestParam("fDate") String fDate, @RequestParam("fTime") String fTime);
	public void insert(ReserveDTO reserve);
	public ArrayList<ReserveDTO> findByField(String name);
	public void save(ReserveDTO reserve);
}
