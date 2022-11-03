package com.ai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ai.domain.ReserveListDTO;
import com.ai.repository.ReserveListRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Repository
public class ReserveListServiceImpl implements ReserveListService {
	
	@Autowired
	ReserveListRepository repo;
	
	@Override
	public ReserveListDTO insert(ReserveListDTO rList) {
		// TODO Auto-generated method stub
		return repo.insert(rList);
	}

}
