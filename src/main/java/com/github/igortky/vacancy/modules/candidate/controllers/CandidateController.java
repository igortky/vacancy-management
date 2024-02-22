package com.github.igortky.vacancy.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.github.igortky.vacancy.modules.candidate.CandidateEntity;
import com.github.igortky.vacancy.modules.candidate.CandidateRepository;
import com.github.igortky.vacancy.modules.candidate.exceptions.UserFoundException;
import com.github.igortky.vacancy.modules.candidate.useCases.CreateCandidateUseCase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")

public class CandidateController {

  @Autowired
  private CreateCandidateUseCase createCandidateUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidate) {
   try {
    var result =  this.createCandidateUseCase.execute(candidate);
    return ResponseEntity.ok().body(result);
   }catch(Exception e) {
    return ResponseEntity.badRequest().body(e.getMessage());
   }
  }
}
