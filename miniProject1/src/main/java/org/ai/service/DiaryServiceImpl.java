package org.ai.service;

import java.util.List;

import org.ai.domain.Criteria;
import org.ai.domain.DiaryVO;
import org.ai.mapper.DiaryMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class DiaryServiceImpl implements DiaryService {
	@Autowired
	DiaryMapper mapper;

	@Override
	public void insert(@Param("title")String title, @Param("writer")String writer, @Param("content") String content) {
		// TODO Auto-generated method stub
		mapper.insert(title, writer, content);
	}

	@Override
	public List<DiaryVO> show(@Param("writer")String writer) {
		// TODO Auto-generated method stub
		return mapper.show(writer);
	}

	@Override
	public List<DiaryVO> showPaging(@Param("writer")String writer, @Param("cri")Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.showPaging(writer, cri);
	}

	@Override
	public DiaryVO get(@Param("diaryNumber")Integer diaryNumber) {
		// TODO Auto-generated method stub
		return mapper.get(diaryNumber);
	}
}
