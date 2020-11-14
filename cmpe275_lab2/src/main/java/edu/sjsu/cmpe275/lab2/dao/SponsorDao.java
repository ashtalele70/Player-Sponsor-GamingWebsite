package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.model.Sponsor;

public interface SponsorDao {

  Sponsor getSponsorById(Long id);

void createSponsor(String name, String description, String street, String city, String state, String zip);

}
