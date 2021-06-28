package com.pluralsight.entities;

import javax.persistence.*;

@Entity
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String title;
  private String description;

  @ManyToOne
  @JoinColumn(name = "application_id")
  private Application application;
}
