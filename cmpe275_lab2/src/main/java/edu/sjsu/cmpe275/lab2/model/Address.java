package edu.sjsu.cmpe275.lab2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
public class Address {

  @Column
  private String street;

  @Column
  private String city;

  @Column
  private String state;

  @Column
  private String zip;
}
