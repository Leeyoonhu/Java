package org.conan.service;

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
public class BoardServiceTest {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
//	@Test
//	public void testExist() {
//		log.info(service);
//		assertNotNull(service);
//	}
	
	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새글 from service");
		board.setContent("새글내용 from service");
		board.setWriter("새글작성자 from service");
		service.register(board);
//		Service 구현 클래스에서 override한 메서드 역할을 수행
//		mapper와 service는 다름, service는 좀더 세세하게, mapping 한것을 구현하는 느낌임
		log.info("생성된 게시물의 번호 : " + board.getBno());
	}
	
	@Test
	public void testGet() {
		log.info(service.get(6L).getTitle());
	}
	
	@Test
	public void testDelete() {
		log.info("REMOVE RESULT : " + service.remove(6L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(6L);
		if(board == null) {
			return;
		}
		board.setTitle("제목 수정 from Service");
		log.info("MODIFY RESULT : " + service.modify(board));
	}
}
