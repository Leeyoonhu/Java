package org.ai.mapper;

import java.util.List;

import org.ai.domain.BoardVO;
import org.ai.domain.Criteria;
import org.apache.ibatis.annotations.Param;

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
	public void write(BoardVO vo);
	// 글 조회수
	public void plusView(int number);
	// 글보기
	public BoardVO getBoardView(int number);
	// 글검색
	public List<BoardVO> search(@Param("title")String title, @Param("content")String content);
	// 추천수
	public void plusReco(Integer number);
	// 내글보기
	public List<BoardVO> getMyArticle(String nickname);
	// 글 삭제
	public void deleteBoard(Integer number);
	// 글 수정(이미지 o)
	public void update(@Param("number") Integer number, @Param("title") String title, @Param("content") String content, 
			@Param("imageFileName") String imageFileName, @Param("imageFilePath") String imageFilePath);
	// 글 수정(이미지 x)
	public void update2(@Param("number") Integer number, @Param("title") String title, @Param("content") String content);
	// 전체게시판 페이징 조회
	public List<BoardVO> getNoticeListWithPaging(Criteria cri); 
	// 특정게시판 페이징 조회
	public List<BoardVO> getListPaging(@Param("title")String title, @Param("cri")Criteria cri);
	// 내 글 보기 페이징 조회
	public List<BoardVO> getMyArticlePaging(@Param("nickName") String nickName, @Param("cri") Criteria cri);
	// 전체게시판 페이징 조회
	public List<BoardVO> getSearchPaging(@Param("title")String title, @Param("content")String content, @Param("cri") Criteria cri);
}
