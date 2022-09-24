package org.ai.mapper;

import java.util.List;

import org.ai.domain.BoardVO;
import org.ai.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 페이징 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	BoardMapper mapper;
	
	
	// 페이징 테스트 할 것임
	// 크리테리아 디폴트 생성자에 1페이지당 10개씩 보이도록 했음
	@Test
	public void testPaging() {
		// getNoticeListWithPaging(1, 10)
		Criteria cri = new Criteria();
		List<BoardVO> list = mapper.getNoticeListWithPaging(cri);
		for(BoardVO board : list) {
			log.info(board);
		}
	}
	
	@Test
	public void testGetList() {
		List<BoardVO> bList = mapper.getNoticeList();
		for(BoardVO board : bList) {
			log.info(board);
		}
	}
	
}
