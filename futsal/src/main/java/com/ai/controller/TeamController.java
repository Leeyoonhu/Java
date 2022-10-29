package com.ai.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.domain.FieldDTO;
import com.ai.domain.MemberDTO;
import com.ai.domain.TeamDTO;
import com.ai.service.MemberService;
import com.ai.service.TeamService;

@Controller
@RequestMapping(path = "/team")
public class TeamController {
   @Autowired
   TeamService service;
   @Autowired
   MemberService mService;
   
   /*
    * @RequestMapping(value = "", method = RequestMethod.GET) public ModelAndView
    * Team() { ModelAndView mav = new ModelAndView(); mav.setViewName("team"); //
    * 페이지이동 return mav; }
    */
   
   @RequestMapping(value = "/insert", method = RequestMethod.POST) 
   public ModelAndView insertTeam(@RequestParam("name")String tName,@RequestParam("location")String location,
         @RequestParam("birth")String birth,@RequestParam("uniform")String uniform,
         @RequestParam("total")int total,@RequestParam("age")String tAge,
         @RequestParam("manner")int tManner,@RequestParam("message")String TeamInfo, HttpSession session) {
      TeamDTO insertTeam = new TeamDTO();
      ModelAndView mav = new ModelAndView(); 
      String userId = (String)session.getAttribute("userId");
      String _id = mService.findBy_id(userId).getNickName();
      insertTeam.set_id(_id); 
      insertTeam.setTName(tName);
      insertTeam.setTArea(location);
      insertTeam.setFoundingDate(birth);
      insertTeam.setUniform(uniform);
      insertTeam.setTTotal(total);
      insertTeam.setTAge(tAge);
      insertTeam.setTManner(tManner);
      insertTeam.setTeamInfo(TeamInfo);
      MemberDTO member = mService.findBy_id(userId);
      member.setTName(tName);
      mService.save(member);
      TeamDTO insertedTeam = service.insert(insertTeam);
      mav.addObject("insertedTeam", insertedTeam); 
      mav.setViewName("/main");
      
      System.out.println("insert tName : " + insertedTeam.getTName());
      System.out.println("insert tArea : " + insertedTeam.getTArea());
      System.out.println("insert fDate : " + insertedTeam.getFoundingDate());
      System.out.println("insert tUniform : " + insertedTeam.getUniform());
      System.out.println("insert tTotal : " + insertedTeam.getTTotal());
      System.out.println("insert tAge : " + insertedTeam.getTAge());
      System.out.println("insert tManner : " + insertedTeam.getTManner());
      System.out.println("insert tInfo : " + insertedTeam.getTeamInfo());
      
      return mav;
   }
   
   @RequestMapping(value = "/myteamtest")
   public ModelAndView moveToTeam(@RequestParam("tName") String tName, HttpSession session) { 
      TeamDTO myteam = service.findBytName(tName);
      ModelAndView mav = new ModelAndView();
      mav.addObject("myteam", myteam);
      mav.setViewName("/myteamtest");
      return mav;
   }
   
   @RequestMapping(value = "/search", method = RequestMethod.POST)
   public ModelAndView search(@RequestParam("tName")String tName, HttpSession session) {
      ModelAndView mav = new ModelAndView();
      System.out.println("찾는 문자열 : " + tName);
      ArrayList<TeamDTO> team = service.findByTNameRegex(tName);
      mav.addObject("sTeamList", team);
      mav.addObject("member", mService.findBy_id((String)session.getAttribute("userId")));
      System.out.println("팀컨트롤러 문자열포함서치된팀리스트 : " + team);
      mav.setViewName("/searchTeam"); // 페이지이동    
      return mav;
   }
}