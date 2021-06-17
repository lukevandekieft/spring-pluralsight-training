package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

import javax.annotation.PostConstruct;

public class SpeakerServiceImpl implements SpeakerService {

  private SpeakerRepository repository;

  public SpeakerServiceImpl() {
    System.out.println("repository Constructor");
  }

  public SpeakerServiceImpl(SpeakerRepository repository) {
    this.repository = repository;
  }

  // Doesn't work in XML: need to be Java-based since the container isn't managed here
  @PostConstruct
  private void initialize() {
    System.out.println("Called after constructors");
  }

  public void setSpeakerRepository(SpeakerRepository repository) {
    this.repository = repository;
  }

  public List<Speaker> findAll() {
    return repository.findAll();
  }
}
