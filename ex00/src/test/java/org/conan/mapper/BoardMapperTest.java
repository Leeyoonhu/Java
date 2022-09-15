package org.conan.mapper;

import org.conan.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

//	@Test
//	public void testGetList() {
//		// board 객체 하나씩
//		mapper.getList().forEach(board -> log.info(board)); // 람다식
//	}
//
//	@Test
//	public void testInsert() {
////		board객체 생성하고, setter로 값넣어줌
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("newbie");
////		insert 함수가 getter불러와서 지정한 value 위치에맞게 값 가져갈것임
//		mapper.insert(board);
//
//		log.info(board);
//	}
//
//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글2");
//		board.setContent("새로 작성하는 내용2");
//		board.setWriter("newbie2");
//
//		mapper.inserSelectKey(board);
//		log.info(board);
//	}
	
//	@Test
//	public void testRead() {
//		BoardVO board = mapper.read(5L);
//		log.info(board);
//	}
	
//	@Test
//	public void testDelete() {
////		bno = 5 삭제시 보여지는 로그
//		log.info("DELETE COUNT : " +mapper.delete(5L));
//	}
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(2L);
		board.setTitle("수정제목");
		board.setContent("수정내용");
		board.setWriter("rose");
		int count = mapper.update(board);
		log.info("UPADTE COUNT : "+count);
	}
}
