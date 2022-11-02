package com.ai.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.domain.ReserveDTO;
import com.ai.repository.ReserveRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Repository
public class ReserveServiceImpl implements ReserveService {
	@Autowired
	ReserveRepository reserveRepository;

	@Override
	public ReserveDTO findReserveToA(String name, String tName1, String fDate, String fTime) {
		ReserveDTO reserve = new ReserveDTO(); 
		reserve = reserveRepository.findByFieldAndNameAAndDateAndTime(name, tName1, fDate, fTime);
		return reserve;
	}

	@Override
	public ReserveDTO findReserveToB(String name, String fDate, String fTime) {
		ReserveDTO reserve = new ReserveDTO();
		reserve = reserveRepository.findByFieldAndDateAndTime(name, fDate, fTime);
		return reserve;
	}
	
	@Override
	public void insert(ReserveDTO reserve) {
		System.out.println("예약 신청 완료");
		reserveRepository.insert(reserve);
	}

	@Override
	public ArrayList<ReserveDTO> findByField(String name) {
		ArrayList<ReserveDTO> reserveList = new ArrayList<>();
		reserveList = reserveRepository.findByField(name);
		return reserveList;
	}


}
