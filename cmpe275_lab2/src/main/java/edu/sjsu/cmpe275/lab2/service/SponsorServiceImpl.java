package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.dao.SponsorDao;
import edu.sjsu.cmpe275.lab2.model.Sponsor;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SponsorServiceImpl implements SponsorService {

  
  SponsorDao sponsorDao;
  
  @Autowired
  public SponsorServiceImpl(SponsorDao sponsorDao) {
	  this.sponsorDao = sponsorDao;
  }

  @Override
  public Sponsor getSponsorById(Long id) {
    return sponsorDao.getSponsorById(id);
  }

  @Override
  @Transactional
  public Sponsor createSponsor(String name, String description, String street, String city, String state, String zip) {

     return 	sponsorDao.createSponsor(name,description,street,city,state,zip);
  }

  @Override
  @Transactional
  public Sponsor deleteSponsor(Long id) {
    return sponsorDao.deleteSponsor(id);
  }

@Override
@Transactional
public Sponsor updateSponsor(Long id,String name, String description, String street, String city, String state, String zip) {
	return sponsorDao.updateSponsor(id,name,description,street,city,state,zip);
	
}


}
