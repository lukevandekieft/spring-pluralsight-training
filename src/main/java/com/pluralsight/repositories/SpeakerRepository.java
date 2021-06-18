package com.pluralsight.repositories;

import com.pluralsight.models.Speaker;

import java.util.List;

public interface SpeakerRepository {
  List<Speaker> findAll();
}
