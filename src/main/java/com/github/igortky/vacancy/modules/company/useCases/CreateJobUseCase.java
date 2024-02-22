package com.github.igortky.vacancy.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.igortky.vacancy.modules.company.entities.JobEntity;
import com.github.igortky.vacancy.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {

  @Autowired
  JobRepository jobRepository;

  public JobEntity execute(JobEntity jobEntity) {
    return this.jobRepository.save(jobEntity);
  }
}
