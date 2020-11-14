package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.dao.SponsorDao;
import edu.sjsu.cmpe275.lab2.model.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SponsorServiceImpl implements SponsorService {

  @Autowired
  SponsorDao sponsorDao;

  @Override
  public Sponsor getSponsorById(Long id) {
    return sponsorDao.getSponsorById(id);
  }

@Override
public void createSponsor(String name, String description, String street, String city, String state, String zip) {
	
	 sponsorDao.createSponsor(name,description,street,city,state,zip);
}


}
