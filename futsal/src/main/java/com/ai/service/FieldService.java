package com.ai.service;

import java.util.ArrayList;

import com.ai.domain.FieldDTO;

public interface FieldService {
	public FieldDTO findByid(String id);
	public ArrayList<FieldDTO> findAll();
	public FieldDTO findByfName(String fName);
}
