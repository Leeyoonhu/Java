package org.conan.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.conan.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTest {
	@Setter(onMethod_ = @Autowired)
		ReplyMapper mapper;
//	DB에 현존하는 게시글 댓글 달것임
	private Long[] bnoArray = {1L, 2L, 3L, 4L, 5L};
	private ReplyVO rvo = null;
	Long targetRno = null;
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			rvo = new ReplyVO(); 
			rvo.setBno(bnoArray[i % 5]);
			rvo.setReply("댓글 내용 " + i);
			rvo.setReplyer("댓글 작성자 " + i);
			mapper.insert(rvo);
//			1부터 10까지 댓글 다는데 bno는 1~5쓸거니까 5로 나눈 나머지 번호에 작성하게 해줌 
		});
	}
	
	@Test
	public void testRead() {
		targetRno = 5L;
//		5번 댓글 소환
		rvo = mapper.read(targetRno);
		log.info(rvo);
	}
	
	@Test
	public void testDelete() {
//		1번 댓글 삭제
		targetRno = 1L;
		mapper.delete(targetRno);
	}
	
	@Test
	public void testUpdate() {
		targetRno = 10L;
		rvo = mapper.read(targetRno);
//		10번 댓글 내용 변경
		rvo.setReply("Update Reply");
//		업데이트 됬으면 1
		int count = mapper.update(rvo);
		log.info("Update Count : " + count);
	}
//	댓글 리스트 보기
	@Test
	public void testList() {
		List<ReplyVO> replies = mapper.getListByBno(bnoArray[0]);
		replies.forEach(reply -> log.info(reply));
	}
	
}
