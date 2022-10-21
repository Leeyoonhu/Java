package com.ai.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
      System.out.println(userId);
      System.out.println(platform);
      MemberDTO joinedMember = service.insert(joinMember); //set한거 DB에넣고, joinedMember에 담기
      mav.addObject("joinedMember", joinedMember);
      mav.setViewName("redirect:/main"); 
      System.out.println(joinedMember.getName()+ "\n" + joinedMember.getNickName() + "\n" + 
            joinedMember.getSex() + "\n" + joinedMember.getPhoneNo()
            + "\n" + joinedMember.getTName() + "\n" + joinedMember.getHadPoint() + "\n"); 
      return mav; 
   }


}