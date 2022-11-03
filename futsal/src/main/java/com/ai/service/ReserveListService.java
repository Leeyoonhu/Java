package com.ai.service;

import org.springframework.stereotype.Service;

import com.ai.domain.ReserveListDTO;

@Service
public interface ReserveListService {
	ReserveListDTO insert(ReserveListDTO rList);
}
