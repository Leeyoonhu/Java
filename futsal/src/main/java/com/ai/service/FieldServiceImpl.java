package com.ai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.repository.FieldRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FieldServiceImpl implements FieldService {
	@Autowired
	FieldRepository fieldRepository;
	
	public String selectField(String fName) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			if(fieldRepository.findByfName(fName) == null) {
				log.info("[Service] fName : {} 존재하지 않습니다!!", fName);
				return String.format("fName : %s 존재하지 않습니다!!", fName);
			}
			else {
				return objMapper.writeValueAsString(fieldRepository.findByfName(fName));
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
}
