package org.ai.mapper;

import java.util.List;

import org.ai.domain.BoardVO;

public interface BoardMapper {
	// 특정 보드 조회
	public List<BoardVO> getList(String title);
	// 전체 게시판 조회
	public List<BoardVO> getNoticeList();
	// 전체 게시판에서 인기 게시판 위주
	public List<BoardVO> getPopularList();
	// 전체 게시판에서 최근 게시판 위주
	public List<BoardVO> getCurrentList();
	// 글쓰기	
	public int write(BoardVO vo);
	// 글보기
	public BoardVO getBoardView(int number);
	// 글검색
	public List<BoardVO> search(String searchTitle, String content);
}
