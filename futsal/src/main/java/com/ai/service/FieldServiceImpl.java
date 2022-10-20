package com.ai.service;

import java.util.ArrayList;

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
	
	public FieldDTO findByid(String id) {
		FieldDTO field = fieldRepository.findByid(id);
		try {
			if(fieldRepository.findByid(id) == null) {
				return null;
			}
			else {
				return field;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return field;
	}

	@Override
	public ArrayList<FieldDTO> findAll() {
		// TODO Auto-generated method stub
		ArrayList<FieldDTO> fList = (ArrayList<FieldDTO>) fieldRepository.findAll();
		return fList;
	}

	@Override
	public FieldDTO findByfName(String fName) {
		System.out.println(fName);
		FieldDTO field = fieldRepository.findByfName(fName);
		return field;
	}
	
}
