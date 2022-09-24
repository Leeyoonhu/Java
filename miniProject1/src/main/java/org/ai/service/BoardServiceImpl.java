package org.ai.service;

import java.util.List;

import org.ai.domain.BoardVO;
import org.ai.domain.Criteria;
import org.ai.mapper.BoardMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {
	@Setter(onMethod_ = @Autowired)
	BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList(String title) {
		// TODO Auto-generated method stub
		log.info("service : " +mapper.getList(title).size());
		return mapper.getList(title);
	}
	
	@Override
	public List<BoardVO> getNoticeList() {
		// TODO Auto-generated method stub
		return mapper.getNoticeList();
	}

	@Override
	public List<BoardVO> getPopularList() {
		// TODO Auto-generated method stub
		return mapper.getPopularList();
	}

	@Override
	public List<BoardVO> getCurrentList() {
		// TODO Auto-generated method stub
		return mapper.getCurrentList();
	}

	@Override
	public void write(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.write(vo);
	}

	@Override
	public void plusView(int number) {
		// TODO Auto-generated method stub
		mapper.plusView(number);
	}
	
	@Override
	public BoardVO getBoardView(int number) {
		// TODO Auto-generated method stub
		return mapper.getBoardView(number);
	}

	@Override
	public List<BoardVO> search(@Param("title") String title, @Param("content") String content) {
		// TODO Auto-generated method stub
		if(title.equals("제목")) {
			title = "title";
		}
		if(title.equals("닉네임")) {
			title = "writer";
		}
		return mapper.search(title, content);
	}

	@Override
	public void plusReco(Integer number) {
		// TODO Auto-generated method stub
		mapper.plusReco(number);
	}

	@Override
	public List<BoardVO> getMyArticle(String nickname) {
		// TODO Auto-generated method stub
		return mapper.getMyArticle(nickname);
	}

	@Override
	public void deleteBoard(Integer number) {
		// TODO Auto-generated method stub
		mapper.deleteBoard(number);
	}

	@Override
	public void update(@Param("number") Integer number, @Param("title") String title, @Param("content") String content, 
			@Param("imageFileName") String imageFileName, @Param("imageFilePath") String imageFilePath) {
		// TODO Auto-generated method stub
		mapper.update(number, title, content, imageFileName, imageFilePath);
	}

	@Override
	public void update2(@Param("number") Integer number, @Param("title") String title, @Param("content") String content) {
		// TODO Auto-generated method stub
		mapper.update2(number, title, content);
	}
	
	
	@Override 
	public List<BoardVO> getNoticeListWithPaging(Criteria cri) {
	   log.info("getList with criteria : "+cri); 
	   return mapper.getNoticeListWithPaging(cri); 
	}

	@Override
	public List<BoardVO> getListPaging(@Param("title")String title, @Param("cri")Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListPaging(title, cri);
	}
	
	@Override
	public List<BoardVO> getMyArticlePaging(@Param("nickName") String nickName, @Param("cri") Criteria cri){
		return mapper.getMyArticlePaging(nickName, cri);
	}

	@Override
	public List<BoardVO> getSearchPaging(@Param("title")String title, @Param("content")String content, @Param("cri") Criteria cri) {
		// TODO Auto-generated method stub
		if(title.equals("제목")) {
			title = "title";
		}
		if(title.equals("닉네임")) {
			title = "writer";
		}
		return mapper.getSearchPaging(title, content, cri);
	}
	
	
}
