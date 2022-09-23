package org.ai.mapper;

import java.util.List;

import org.ai.domain.CommentVO;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
	public List<CommentVO> getList();
	
	public void insert(@Param("number")Integer number, @Param("writer") String writer, @Param("comment") String comment);

	
}
