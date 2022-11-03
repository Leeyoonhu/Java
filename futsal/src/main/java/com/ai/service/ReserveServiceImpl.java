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
	ReserveRepository repo;

	@Override
	public ReserveDTO findReserveToA(String name, String tName1, String fDate, String fTime) {
		ReserveDTO reserve = new ReserveDTO(); 
		reserve = repo.findByFieldAndNameAAndDateAndTime(name, tName1, fDate, fTime);
		return reserve;
	}

	@Override
	public ReserveDTO findReserve(String name, String fDate, String fTime) {
		ReserveDTO reserve = new ReserveDTO();
		reserve = repo.findByFieldAndDateAndTime(name, fDate, fTime);
		return reserve;
	}
	
	@Override
	public void insert(ReserveDTO reserve) {
		System.out.println("예약 신청 완료");
		repo.insert(reserve);
	}
	
	@Override
	public void save(ReserveDTO reserve) {
		// TODO Auto-generated method stub
		System.out.println("B팀 신청 완료");
		repo.save(reserve);
	}
	
	@Override
	public ArrayList<ReserveDTO> findByField(String name) {
		ArrayList<ReserveDTO> reserveList = new ArrayList<>();
		reserveList = repo.findByField(name);
		return reserveList;
	}
}
