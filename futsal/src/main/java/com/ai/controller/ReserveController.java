package com.ai.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.domain.MemberDTO;
import com.ai.domain.ReserveDTO;
import com.ai.domain.ReserveListDTO;
import com.ai.service.FieldService;
import com.ai.service.MemberService;
import com.ai.service.ReserveListService;
import com.ai.service.ReserveService;

@Controller
@RequestMapping(path = "/reserveTo")
public class ReserveController {
	@Autowired
	ReserveService service;
	
	@Autowired
	MemberService mService;

	@Autowired
	FieldService fService;
	
	@Autowired
	ReserveListService rlService;
	
	@RequestMapping(value = "/checkAjax", method = RequestMethod.POST)
	public void checkAjax(@RequestParam("field")String field, @RequestParam("fTime") String fTime, @RequestParam("fDate") String fDate, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		System.out.println("구장명 : " + field + ", 날짜 : " + fDate +  ", 시간 : " + fTime);
		try {
			if(service.findReserve(field, fDate, fTime).getState() == null) {
				out.print("null");
			}
			else {
				out.print(service.findReserve(field, fDate, fTime).getState());
			}
		} catch (NullPointerException e) {
			out.print("null");
		}
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertReserve(@RequestParam("fName") String fName, @RequestParam("fPrice") String fPrice, @RequestParam("fDate") String fDate,
			@RequestParam("fTime") String fTime, @RequestParam("fPhoneNo") String fPhoneNo, @RequestParam("type") String type,
			@RequestParam("rState") String rState, @RequestParam("nickName1") String nickName1, @RequestParam("tName1") String tName1, 
			@RequestParam("rDate1") String rDate1, @RequestParam("nickName2") String nickName2, @RequestParam("tName2") String tName2,
			@RequestParam("rDate2") String rDate2)
	{	
		ReserveDTO reserve = new ReserveDTO();
		reserve.setField(fName);
		reserve.setPrice(fPrice);
		Integer price = Integer.parseInt(fPrice.replace(",", "").replace(" P", "")); 
		System.out.println("가격 : " + price);
		reserve.setDate(fDate);
		reserve.setTime(fTime);
		reserve.setPhoneNo(fPhoneNo);
		reserve.setType(type);
		reserve.setState(rState);
		reserve.setNickNameA(nickName1);
		reserve.setNameA(tName1);
		reserve.setDateA(rDate1);
		reserve.setNickNameB(nickName2);
		reserve.setNameB(tName2);
		reserve.setDateB(rDate2);		
		MemberDTO member = mService.findByNickName(nickName1);
		member.setHadPoint(member.getHadPoint() - price);
		mService.save(member);
		service.insert(reserve);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveReserve(
			@RequestParam("field")String field, @RequestParam("fTime") String fTime, @RequestParam("fDate") String fDate, 
			@RequestParam("nickName2") String nickName2, @RequestParam("tName2") String tName2, @RequestParam("rDate2") String rDate2)
	{	
		/* 예약정보 변경 -B
		ReserveDTO reserve = service.findReserve(field, fDate, fTime);
		reserve.setNickNameB(nickName2);
		reserve.setNameB(tName2);
		reserve.setDateB(rDate2);
		service.save(reserve);
		*/
		// 예약리스트에도 넣어야함
		ReserveListDTO rList = new ReserveListDTO();
		rList.setField(field);
		rList.setPrice(String.format("%d", fService.findByfName(field).getfPrice1()));
		rList.setDate(fDate);
		rList.setTime(fTime);
		rList.setTeam(tName2);
		rList.setNickName(nickName2);
		rList.setRegDate(rDate2);
		rlService.insert(rList);
		return "redirect:/main";
	}
}
