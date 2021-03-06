package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.model.Sponsor;

public interface SponsorService {

  public Sponsor getSponsorById(Long id);

  public Sponsor createSponsor(String name, String description, String street, String city, String state, String zip);

  public Sponsor deleteSponsor(Long id);
  
  public Sponsor updateSponsor(Long id,String name, String description, String street, String city, String state, String zip);
}
