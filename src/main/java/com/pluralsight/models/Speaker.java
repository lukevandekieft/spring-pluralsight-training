package com.pluralsight.models;

public class Speaker {
  private String firstName;
  private String lastName;
  private Double seedNum;

  public String getFirstName() {
    return firstName;
  }

  public Double getSeedNum() {
    return seedNum;
  }

  public void setSeedNum(Double seedNum) {
    this.seedNum = seedNum;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
