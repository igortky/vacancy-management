package com.github.igortky.vacancy.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.igortky.vacancy.modules.candidate.CandidateEntity;
import com.github.igortky.vacancy.modules.candidate.CandidateRepository;
import com.github.igortky.vacancy.modules.candidate.exceptions.UserFoundException;

@Service
public class CreateCandidateUseCase {

  @Autowired
  private CandidateRepository candidateRepository;

public CandidateEntity execute(CandidateEntity candidate) {
    this.candidateRepository
        .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
        .ifPresent((user) -> {
          throw new UserFoundException();
        });;

        return this.candidateRepository.save(candidate);
  }

}
