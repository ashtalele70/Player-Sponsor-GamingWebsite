package edu.sjsu.cmpe275.lab2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
public class Address {

  private String street;

  private String city;

  private String state;

  private String zip;
}
