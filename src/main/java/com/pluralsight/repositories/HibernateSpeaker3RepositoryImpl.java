package com.pluralsight.repositories;

import com.pluralsight.models.Speaker3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository("speaker3Repository")
public class HibernateSpeaker3RepositoryImpl implements Speaker3Repository {

  @Qualifier("cal")
  @Autowired
  private Calendar cal;

  @Value("#{ T(java.lang.Math).random() * 100 }")
  private double seedNum;

  public List<Speaker3> findAll() {
    List<Speaker3> speakers = new ArrayList<Speaker3>();

    Speaker3 speaker = new Speaker3();
    speaker.setFirstName("Luke");
    speaker.setLastName("Vandekieft");
    speaker.setSeedNum(seedNum);

    System.out.println("cal: " + cal.getTime());

    speakers.add(speaker);

    return speakers;
  }
}
