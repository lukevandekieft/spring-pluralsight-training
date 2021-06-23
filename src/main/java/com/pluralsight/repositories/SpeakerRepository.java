package com.pluralsight.repositories;

import com.pluralsight.models.Speaker3;

import java.util.List;

public interface SpeakerRepository {
  List<Speaker3> findAll();
}
