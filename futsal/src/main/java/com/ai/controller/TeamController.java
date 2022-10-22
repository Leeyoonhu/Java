package com.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ai.domain.TeamDTO;
import com.ai.service.TeamService;

@Controller
@RequestMapping(path = "/team")
public class TeamController {
   
   @Autowired
   TeamService service;
   /*
    * @RequestMapping(value = "", method = RequestMethod.GET) public ModelAndView
    * Team() { ModelAndView mav = new ModelAndView(); mav.setViewName("team"); //
    * 페이지이동 return mav; }
    */
   
   @RequestMapping(value = "/search", method = RequestMethod.POST)
   public ModelAndView search(@RequestParam("tName")String tName) {
      ModelAndView mav = new ModelAndView();
      TeamDTO team = service.findBytName(tName);
      mav.addObject("searchedTeam", team);
      System.out.println(team.getTName());
      mav.setViewName("/teamtables"); // 페이지이동    
      return mav;
   }
   
   @RequestMapping(value = "/insert", method = RequestMethod.POST) 
   public ModelAndView insertTeam(@RequestParam("name")String tName,@RequestParam("location")String location,
         @RequestParam("birth")String birth,@RequestParam("uniform")String uniform,
         @RequestParam("total")int total,@RequestParam("age")String tAge,
         @RequestParam("manner")int tManner,@RequestParam("message")String TeamInfo) {
      TeamDTO insertTeam = new TeamDTO();
      ModelAndView mav = new ModelAndView(); 
      insertTeam.setTName(tName);
      insertTeam.setTArea(location);
      insertTeam.setFoundingDate(birth);
      insertTeam.setUniform(uniform);
      insertTeam.setTTotal(total);
      insertTeam.setTAge(tAge);
      insertTeam.setTManner(tManner);
      insertTeam.setTeamInfo(TeamInfo);
      
      TeamDTO insertedTeam = service.insert(insertTeam);
      mav.addObject("insertedTeam", insertedTeam); 
      mav.setViewName("/main");
      System.out.println(insertedTeam.getTName() + "\n" + insertedTeam.getTArea() + "\n" + 
            insertedTeam.getFoundingDate() + "\n" + insertedTeam.getUniform() + "\n" +
            insertedTeam.getTTotal() + "\n" + insertedTeam.getTAge() + "\n" + insertedTeam.getTManner()
            + "\n" + insertedTeam.getTeamInfo());
      return mav;
   }
}