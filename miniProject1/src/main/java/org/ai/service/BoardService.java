package org.ai.service;

import java.util.List;

import org.ai.domain.BoardVO;
import org.ai.domain.Criteria;
import org.ai.domain.MemberVO;
import org.apache.ibatis.annotations.Param;

public interface BoardService {
	public List<BoardVO> getList(String title);
	public List<BoardVO> getNoticeList();
	public List<BoardVO> getPopularList();
	public List<BoardVO> getCurrentList();
	public void write(BoardVO vo);
	public void plusView(int number);
	public BoardVO getBoardView (int number);
	public List<BoardVO> search(@Param("title") String title, @Param("content") String content);
	public void plusReco(Integer number);
	public List<BoardVO> getMyArticle(String nickname);
	public void deleteBoard(Integer number);
	public void update(@Param("number") Integer number, @Param("title") String title, @Param("content") String content, 
			@Param("imageFileName") String imageFileName, @Param("imageFilePath") String imageFilePath);
	public void update2(@Param("number") Integer number, @Param("title") String title, @Param("content") String content);
	public List<BoardVO> getNoticeListWithPaging(Criteria cri);
	public List<BoardVO> getListPaging(@Param("title")String title, @Param("cri")Criteria cri);
	public List<BoardVO> getMyArticlePaging(@Param("nickName") String nickName, @Param("cri") Criteria cri);
	public List<BoardVO> getSearchPaging(@Param("title")String title, @Param("content")String content, @Param("cri") Criteria cri);
	public BoardVO getOne(@Param("boardTitle")String boardTitle);
	public List<BoardVO> getThree(@Param("boardTitle") String boardTitle);
}
