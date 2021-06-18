package com.pluralsight.services;

import com.pluralsight.models.Speaker;

import java.util.List;

public interface SpeakerService {
  List<Speaker> findAll();
}
