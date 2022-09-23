package org.ai.service;

import java.util.List;

import org.ai.domain.CommentVO;
import org.apache.ibatis.annotations.Param;

public interface CommentService {
	public List<CommentVO> getList();
	public List<CommentVO> get(Integer number);
	public void insert(@Param("number")Integer number, @Param("writer") String writer, @Param("comment") String comment);
}
