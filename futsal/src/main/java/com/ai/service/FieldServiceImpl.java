package com.ai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.domain.FieldDTO;
import com.ai.repository.FieldRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FieldServiceImpl implements FieldService {
	@Autowired
	FieldRepository fieldRepository;
	
	public FieldDTO selectField(String id) {
		ObjectMapper objMapper = new ObjectMapper();
		FieldDTO field = fieldRepository.findByid(id);
		try {
			if(fieldRepository.findByid(id) == null) {
				return null;
			}
			else {
//				return objMapper.writeValueAsString(fieldRepository.findByid(id));
				return field;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return field;
	}
}
