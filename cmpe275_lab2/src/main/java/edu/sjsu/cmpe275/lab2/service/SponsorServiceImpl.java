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

	/**
	 * This is a method for getting sponsor details by ID.
	 * 
	 * @param id id of the sponsor
	 * @return deep Sponsor object
	 * 
	 */
	@Override
	public Sponsor getSponsorById(Long id) {
		return sponsorDao.getSponsorById(id);
	}

	/**
	 * This is a method for creating a sponsor. The name parameter is mandatory.
	 * 
	 * @param name        name of the sponsor
	 * @param description description of the sponsor
	 * @param street      sponsor's street address
	 * @param city        sponsor's city
	 * @param state       sponsor's state
	 * @param zip         sponsor's zipcode
	 * @return deep copy of the created Sponsor object
	 * 
	 */
	@Override
	@Transactional
	public Sponsor createSponsor(String name, String description, String street, String city, String state,
			String zip) {

		return sponsorDao.createSponsor(name, description, street, city, state, zip);
	}

	/**
	 * This is a method for deleting a sponsor.
	 * 
	 * @param id id of the sponsor
	 * @return deep copy of the deleted Sponsor object
	 * 
	 */
	@Override
	@Transactional
	public Sponsor deleteSponsor(Long id) {
		return sponsorDao.deleteSponsor(id);
	}

	/**
	 * This is a method for updating a sponsor. The name parameter is mandatory.
	 * 
	 * @param name        name of the sponsor
	 * @param description description of the sponsor
	 * @param street      sponsor's street address
	 * @param city        sponsor's city
	 * @param state       sponsor's state
	 * @param zip         sponsor's zipcode
	 * @return deep copy of the updated Sponsor object
	 * 
	 */
	@Override
	@Transactional
	public Sponsor updateSponsor(Long id, String name, String description, String street, String city, String state,
			String zip) {
		return sponsorDao.updateSponsor(id, name, description, street, city, state, zip);

	}

}
