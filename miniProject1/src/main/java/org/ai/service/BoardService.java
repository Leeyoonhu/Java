package org.ai.service;

import java.util.List;

import org.ai.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> getList(String title);
	public List<BoardVO> getNoticeList();
	public List<BoardVO> getPopularList();
	public List<BoardVO> getCurrentList();
	public boolean write(BoardVO vo);
	public void plusView(int number);
	public BoardVO getBoardView (int number);
	public List<BoardVO> search(String searchTitle, String content);
	public void plusReco(Integer number);
}
