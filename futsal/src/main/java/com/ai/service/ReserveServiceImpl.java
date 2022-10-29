package com.ai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ai.domain.ReserveDTO;
import com.ai.repository.ReserveReposiotry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Repository
public class ReserveServiceImpl implements ReserveService {
	@Autowired
	ReserveReposiotry reserveRepository;

	@Override
	public ReserveDTO findByNameAndNameAAndTime(String name, String tName1, String fTime) {
		ReserveDTO reserve = new ReserveDTO(); 
		reserve = reserveRepository.findByNameAndNameAAndTime(name, tName1, fTime);
		return reserve;
	}

	@Override
	public void insert(ReserveDTO reserve) {
		System.out.println("예약 신청 완료");
		reserveRepository.insert(reserve);
	}


}
