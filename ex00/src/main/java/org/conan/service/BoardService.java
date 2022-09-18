package org.conan.service;

import java.util.List;

import org.conan.domain.BoardVO;

// 비즈니스 계층
public interface BoardService {
	public void register(BoardVO board);
//	등록
	public BoardVO get(Long bno);
//	조회
	public boolean modify(BoardVO board);
//	수정
	public boolean remove(Long bno);
//	삭제
	public List<BoardVO> getList();
}
