package com.github.igortky.vacancy.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.igortky.vacancy.modules.company.entities.CompanyEntity;
import com.github.igortky.vacancy.modules.company.useCases.CreateCompanyUseCase;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  CreateCompanyUseCase createCompanyUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyEntity companyEntity) {
    try {
         var result = this.createCompanyUseCase.execute(companyEntity);
        return ResponseEntity.ok().body(result);
      } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
      }
  }


}
