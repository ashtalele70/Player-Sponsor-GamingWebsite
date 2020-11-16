package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class SponsorDaoImpl implements SponsorDao {

  
  private EntityManager entityManager;
 
  @Autowired
  public SponsorDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
  @Override
	  public Sponsor getSponsorById(Long id) {
			Sponsor sponsor = entityManager.find(Sponsor.class, id);
	  	return sponsor;
	  }
  


@Override
public void createSponsor(String name, String description, String street, String city, String state, String zip) {
	Sponsor sponsor=new Sponsor();
	Address address=new Address();
	address.setStreet(street);
	address.setCity(city);
	address.setState(state);
	address.setZip(zip);
	sponsor.setName(name);
	sponsor.setDescription(description);
	sponsor.setAddress(address);
	entityManager.merge(sponsor);
}



@Override
public void deleteSponsor(Long id) {
	Query query = entityManager.createQuery("delete from Sponsor where id=:id");
	query.setParameter("id", id);
	query.executeUpdate();
}
}
