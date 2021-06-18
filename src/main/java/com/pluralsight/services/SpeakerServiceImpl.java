package com.pluralsight.services;

import com.pluralsight.models.Speaker;
import com.pluralsight.repositories.SpeakerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.PostConstruct;

@Service("speakerService")
//@Profile("prod") <-- if ``Configution -> VM Options`` is set to "prod" then this runs, otherwise the service is skipped
public class SpeakerServiceImpl implements SpeakerService {

  private SpeakerRepository repository;

  public SpeakerServiceImpl() {
    System.out.println("SpeakerServiceImpl no args constructor");
  }

  public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
    System.out.println("SpeakerServiceImpl w/ args constructor");
    repository = speakerRepository;
  }

  @PostConstruct
  private void initialize() {
    System.out.println("Called After Constructor");
  }

  @Autowired
  public void setRepository(SpeakerRepository repository) {
    System.out.println("SpeakerServiceImpl setter");
    this.repository = repository;
  }

  @Override
  public List<Speaker> findAll() {
    return repository.findAll();
  }
}
