package com.github.igortky.vacancy.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.igortky.vacancy.modules.candidate.exceptions.UserFoundException;
import com.github.igortky.vacancy.modules.company.entities.CompanyEntity;
import com.github.igortky.vacancy.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

  @Autowired
  private CompanyRepository companyRepository;

  public CompanyEntity execute(CompanyEntity companyEntity) {
    this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((company) -> {
          throw new UserFoundException();
        });
    return this.companyRepository.save(companyEntity);
  }
}
