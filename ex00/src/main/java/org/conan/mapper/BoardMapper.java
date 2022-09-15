package org.conan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.conan.domain.BoardVO;

public interface BoardMapper {
	/* @Select("select * from tbl_board where bno > 0") */
//	xml 에서 select문 작성했기 때문에 주석처리
	public List<BoardVO> getList();
	public void insert(BoardVO board);
	public void inserSelectKey(BoardVO board);
	public BoardVO read(long bno);
	public int delete(long bno);
	public int update(BoardVO board);
}
