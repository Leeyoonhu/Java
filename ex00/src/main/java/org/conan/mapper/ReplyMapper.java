package org.conan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.conan.domain.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO rvo);
	public ReplyVO read(Long rno);
	public int delete(Long rno);
	public int update(ReplyVO reply);
	public List<ReplyVO> getListByBno(@Param("bno") Long bno);
}
