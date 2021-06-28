package com.pluralsight.entities;

import javax.persistence.*;

@Entity
public class Release {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String releaseDate;
  private String description;

  public Release() {

  }

  public Release(Integer id, String description, String releaseDate){
    this.id = id;
    this.description = description;
    this.releaseDate = releaseDate;
  }
}
