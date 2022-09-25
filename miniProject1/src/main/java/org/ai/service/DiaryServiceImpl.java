package org.ai.service;

import org.ai.mapper.DiaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class DiaryServiceImpl implements DiaryService {
	@Autowired
	DiaryMapper mapper;
}
