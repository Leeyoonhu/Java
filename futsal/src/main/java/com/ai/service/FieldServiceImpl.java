package com.ai.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.domain.FieldDTO;
import com.ai.domain.TeamDTO;
import com.ai.repository.FieldRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FieldServiceImpl implements FieldService {
   @Autowired
   FieldRepository repo;
   
   public FieldDTO findByid(String id) {
      FieldDTO field = repo.findByid(id);
      try {
         if(repo.findByid(id) == null) {
            return null;
         }
         else {
            return field;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return field;
   }

   @Override
   public ArrayList<FieldDTO> findAll() {
      // TODO Auto-generated method stub
      ArrayList<FieldDTO> fList = (ArrayList<FieldDTO>) repo.findAll();
      return fList;
   }

   @Override
   public FieldDTO findByfName(String fName) {
      System.out.println(fName);
      FieldDTO field = repo.findByfName(fName);
      return field;
   }

   @Override
   public ArrayList<FieldDTO> findByFNameRegex(String fName) {
      // TODO Auto-generated method stub
      ArrayList<FieldDTO> fields = repo.findByFNameRegex(fName);
      return fields;
   }
   
}