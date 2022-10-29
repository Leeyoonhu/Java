package com.ai.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.domain.MemberDTO;
import com.ai.domain.ReserveDTO;
import com.ai.service.MemberService;
import com.ai.service.ReserveService;

@Controller
@RequestMapping(path = "/reserveTo")
public class ReserveController {
	@Autowired
	ReserveService service;
	
	@Autowired
	MemberService mService;

	@RequestMapping(value = "/checkAjax", method = RequestMethod.POST)
	public void checkAjax(@RequestParam("name")String name, @RequestParam("tName1") String tName1, @RequestParam("fTime") String fTime, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		System.out.println("구장명 : " + name + ", 팀명 : " + tName1 + ", 필드 : " + fTime);
		try {
			if(service.findByNameAndNameAAndTime(name, tName1, fTime).getState() == null) {
				out.print("null");
			}
			else {
				out.print(service.findByNameAndNameAAndTime(name, tName1, fTime).getState());
			}
		} catch (NullPointerException e) {
			out.print("null");
		}
	}
	
	
	@RequestMapping(value = "/insertA", method = RequestMethod.POST)
	public String insertReserve(@RequestParam("fName") String fName, @RequestParam("fPrice") String fPrice, @RequestParam("fDate") String fDate,
			@RequestParam("fTime") String fTime, @RequestParam("fPhoneNo") String fPhoneNo, @RequestParam("type") String type,
			@RequestParam("rState") String rState, @RequestParam("nickName1") String nickName1, @RequestParam("tName1") String tName1, 
			@RequestParam("rDate1") String rDate1, @RequestParam("nickName2") String nickName2, @RequestParam("tName2") String tName2,
			@RequestParam("rDate2") String rDate2)
	{	
		ReserveDTO reserve = new ReserveDTO();
		reserve.setName(fName);
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
}
