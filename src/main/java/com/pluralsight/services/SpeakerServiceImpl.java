package com.pluralsight.services;

import com.pluralsight.models.Speaker3;
import com.pluralsight.repositories.Speaker3Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.PostConstruct;

@Service("speakerService")
//@Profile("prod") <-- if ``Configution -> VM Options`` is set to "prod" then this runs, otherwise the service is skipped
public class SpeakerServiceImpl implements SpeakerService {

  private Speaker3Repository repository;

  public SpeakerServiceImpl() {
    System.out.println("SpeakerServiceImpl no args constructor");
  }

  public SpeakerServiceImpl(Speaker3Repository speaker3Repository) {
    System.out.println("SpeakerServiceImpl w/ args constructor");
    repository = speaker3Repository;
  }

  @PostConstruct
  private void initialize() {
    System.out.println("Called After Constructor");
  }

  @Autowired
  public void setRepository(Speaker3Repository repository) {
    System.out.println("SpeakerServiceImpl setter");
    this.repository = repository;
  }

  @Override
  public List<Speaker3> findAll() {
    return repository.findAll();
  }
}
