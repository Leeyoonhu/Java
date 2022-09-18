package org.conan.service;

import java.util.List;

import org.conan.domain.ReplyVO;
import org.conan.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceimpl implements ReplyService {
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
//	ReplyVO 정보가 들어있는 vo insert하기
	@Override
	public int register(ReplyVO vo) {
		// TODO Auto-generated method stub
		log.info("register > > > " + vo);
		return mapper.insert(vo);
	}

//	댓글 번호 rno인 댓글 조회
	@Override
	public ReplyVO get(Long rno) {
		// TODO Auto-generated method stub
		log.info("get > > > " + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		log.info("modify > > > " + vo);
		return mapper.update(vo);
	}
	
//	댓글 번호 rno인 댓글 삭제
	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		log.info("remove > > > " + rno);
		return mapper.delete(rno);
	}

//	보드번호 bno 인 모든 댓글 리스트 조회
	@Override
	public List<ReplyVO> getListByBno(Long bno) {
		// TODO Auto-generated method stub
		log.info("getListByBno > > > " + bno);
		return mapper.getListByBno(bno);
	}
	
}
