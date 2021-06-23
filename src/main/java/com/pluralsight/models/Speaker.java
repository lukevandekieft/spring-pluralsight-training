package com.pluralsight.models;

import org.hibernate.annotations.Type;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity(name = "speakers")
public class Speaker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long speaker_id;
  private String first_name;
  private String last_name;
  private String title;
  private String company;
  private String speaker_bio;

  @Lob
  @Type(type = "org.hibernate.type.BinaryType")
  private byte[] speaker_photo;

  public byte[] getSpeaker_photo() {
    return speaker_photo;
  }

  public void setSpeaker_photo(byte[] speaker_photo) {
    this.speaker_photo = speaker_photo;
  }

  public List<Session> getSessions() {
    return sessions;
  }

  public void setSessions(List<Session> sessions) {
    this.sessions = sessions;
  }

  @ManyToMany(mappedBy = "speakers")
  private List<Session> sessions;

  public Speaker() {

  }
}
