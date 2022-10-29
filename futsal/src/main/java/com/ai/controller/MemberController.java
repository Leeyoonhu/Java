package com.ai.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.domain.MemberDTO;
import com.ai.service.MemberService;


@Controller
@RequestMapping(path = "/member")
public class MemberController {
   @Autowired
   MemberService service;
   
   // AJAX
   @RequestMapping(value = "/nickNameAjax")
   public void AjaxToNickName(@RequestParam("nickName")String nickName, HttpServletResponse response) throws Exception {
	   System.out.println("Checking nickName.....");
	   MemberDTO member= service.findByNickName(nickName);
	   PrintWriter out = response.getWriter();
	   if(member != null) {
		   out.print("true");
	   }
	   else {
		   out.print("false");
	   }
   }
   
   // AJAX
   @RequestMapping(value = "/phoneNoAjax", method = RequestMethod.POST)
   public void AjaxToPhoneNo(@RequestParam("phoneNo")String phoneNo, HttpServletResponse response) throws Exception {
	   System.out.println("Checking phoneNo.....");
	   MemberDTO member =  service.findByPhoneNo(phoneNo);
	   PrintWriter out = response.getWriter();
	   if(member != null) {
		   out.print("true");
	   }
	   else {
		   out.print("false");
	   }
   }
   
   
   @RequestMapping(value = "/join", method = RequestMethod.POST) 
   public ModelAndView insert(@RequestParam("name")String name,@RequestParam("nickName")String nickName,
         @RequestParam("sex")String sex, @RequestParam("phoneNo")String phoneNo,
         @RequestParam("tName") String tName , @RequestParam("hadPoint")int hadPoint, HttpSession session, HttpServletRequest request){
      MemberDTO joinMember = new MemberDTO(); 
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String now = sdf.format(date);
      ModelAndView mav = new ModelAndView();
      Cookie[] cookies = request.getCookies();
      Cookie cookie = cookies[1]; 
      String platform = cookie.getValue().toString();
      String userId = (String)session.getAttribute("userId");
      joinMember.set_id(userId); joinMember.setPlatform(platform); joinMember.setRegDate(now);
      joinMember.setName(name); joinMember.setNickName(nickName);
      joinMember.setSex(sex); joinMember.setPhoneNo(phoneNo);
      joinMember.setTName(tName); joinMember.setHadPoint(hadPoint);
      // 
      MemberDTO joinedMember = service.insert(joinMember); //set한거 DB에넣고, joinedMember에 담기
      mav.addObject("joinedMember", joinedMember);
      mav.setViewName("redirect:/main");
      System.out.println("userId : " + userId);
      System.out.println("platform : " + platform);
      System.out.println("Name : " + joinedMember.getName());
      System.out.println("nickName : " + joinedMember.getNickName());
      System.out.println("sex : " + joinedMember.getSex());
      System.out.println("phoneNo : " + joinedMember.getPhoneNo());
      System.out.println("tName : " + joinedMember.getTName());
      System.out.println("Point : " + joinedMember.getHadPoint());
      return mav; 
   }


}