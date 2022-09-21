package org.ai.service;

import java.util.List;

import org.ai.domain.BoardVO;
import org.ai.mapper.BoardMapper;
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
	public boolean write(BoardVO vo) {
		// TODO Auto-generated method stub
		return mapper.write(vo) == 1? true : false;
	}

	@Override
	public BoardVO getBoardView(int number) {
		// TODO Auto-generated method stub
		return mapper.getBoardView(number);
	}

	@Override
	public List<BoardVO> search(String searchTitle, String content) {
		// TODO Auto-generated method stub
		return mapper.search(searchTitle, content);
	}
	
	

}
