package org.ai.service;

import java.util.List;

import org.ai.domain.CommentVO;
import org.ai.mapper.CommentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CommentServiceImpl implements CommentService {
	@Setter(onMethod_ = @Autowired)
	CommentMapper mapper;
	
	@Override
	public List<CommentVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public void insert(@Param("number")Integer number, @Param("writer") String writer, @Param("comment") String comment) {
		// TODO Auto-generated method stub
		mapper.insert(number, writer, comment);
	}
	
}
