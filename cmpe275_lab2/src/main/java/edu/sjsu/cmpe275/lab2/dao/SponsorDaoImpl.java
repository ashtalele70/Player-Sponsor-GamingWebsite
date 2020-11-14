package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.Sponsor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class SponsorDaoImpl implements SponsorDao {

  @Autowired
  private EntityManager entityManager;

  @Override
  public Sponsor getSponsorById(Long id) {
    Session currentSession = entityManager.unwrap(Session.class);
    Query<Sponsor> query = currentSession.createQuery("from Sponsor where id " +
      "=:" +
      " id", Sponsor.class).setParameter("id", id);
    Sponsor sponsor = query.getSingleResult();
    return sponsor;
  }
  


@Override
public void createSponsor(String name, String description, String street, String city, String state, String zip) {
	Session currentSession=entityManager.unwrap(Session.class);
	Sponsor sponsor=new Sponsor();
	Address address=new Address();
	address.setStreet(street);
	address.setCity(city);
	address.setState(state);
	address.setZip(zip);
	sponsor.setName(name);
	sponsor.setDescription(description);
	sponsor.setAddress(address);
	currentSession.save(sponsor);

}
}
