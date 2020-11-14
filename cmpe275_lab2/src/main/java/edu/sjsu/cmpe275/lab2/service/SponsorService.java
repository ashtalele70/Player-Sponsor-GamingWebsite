package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.model.Sponsor;

public interface SponsorService {

  public Sponsor getSponsorById(Long id);

  public void createSponsor(String name, String description, String street, String city, String state, String zip);


}
