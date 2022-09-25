package org.ai.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ai.domain.Criteria;
import org.ai.domain.MemberVO;
import org.ai.mapper.MemberMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImpl implements MemberService {
	@Setter(onMethod_ = @Autowired)
	MemberMapper mapper;
	
	@Override
	public MemberVO login(MemberVO vo) {
		// TODO Auto-generated method stub
		MemberVO memberVO  =mapper.login(vo);
		
		return memberVO!=null ? memberVO : null;
	}

	@Override
	public boolean join(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.join(vo) == 1 ? true : false;
	}

	@Override
	public String idCheck(String userId) {
		// TODO Auto-generated method stub
		// js에서 받은 result가 notnull이면 존재..
		return mapper.idCheck(userId);
	}

	@Override
	public String nickCheck(String nickName) {
		// TODO Auto-generated method stub
		return mapper.nickCheck(nickName);
	}

	@Override
	public String pNCheck(String phoneNo) {
		// TODO Auto-generated method stub
		return mapper.pNCheck(phoneNo);
	}

	@Override
	public String findIdProc(@Param("firstName")String firstName, @Param("lastName")String lastName, @Param("phoneNo")String phoneNo) {
		// TODO Auto-generated method stub
		return mapper.findIdProc(firstName, lastName, phoneNo);
	}
	
	@Override
	public String idToPwdHintQ(String userId) {
		// TODO Auto-generated method stub
		return mapper.idToPwdHintQ(userId);
	}

	@Override
	public String findPwdProc(@Param("userId")String userId, @Param("pwdHint")String pwdHint) {
		// TODO Auto-generated method stub
		return mapper.findPwdProc(userId, pwdHint);
	}

	@Override
	public void attend(String userId) {
		// TODO Auto-generated method stub
		mapper.attend(userId);
	}

	@Override
	public MemberVO renew(String userId) {
		// TODO Auto-generated method stub
		return mapper.renew(userId);
	}

	@Override
	public String loginCheck(@Param("userId")String userId, @Param("userPwd")String userPwd) {
		// TODO Auto-generated method stub
		return mapper.loginCheck(userId, userPwd);
	}

	@Override
	public List<MemberVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public List<MemberVO> getRankListWithPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getRankListWithPaging(cri);
	}

	@Override
	public List<MemberVO> getRankList() {
		// TODO Auto-generated method stub
		return mapper.getRankList();
	}

	
}
