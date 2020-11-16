package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.Sponsor;
import edu.sjsu.cmpe275.lab2.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


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
	  /*
	    Session currentSession = entityManager.unwrap(Session.class);
	    Query<Sponsor> query = currentSession.createQuery("from Sponsor where id " +
	      "=:" +
	      " id", Sponsor.class).setParameter("id", id);
	    Sponsor sponsor = query.getSingleResult();
	    return sponsor;
	    
	   */
	  return new Sponsor();
	  }
  


@Override
public void createSponsor(String name, String description, String street, String city, String state, String zip) {
	//Session currentSession=entityManager.unwrap(Session.class);
	Sponsor sponsor=new Sponsor();
	Address address=new Address();
	address.setStreet(street);
	address.setCity(city);
	address.setState(state);
	address.setZip(zip);
	sponsor.setName(name);
	sponsor.setDescription(description);
	sponsor.setAddress(address);
	//currentSession.save(sponsor);
	entityManager.merge(sponsor);
}



@Override
public void deleteSponsor(Long id) {
	/*
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
    
    EntityManager entitymanager = emfactory.createEntityManager( );
    entitymanager.getTransaction( ).begin( );
	
	Object persistentInstance = currentSession.load(Sponsor.class, id);
	if (persistentInstance != null) {
		currentSession.remove(persistentInstance);
	}
	*/	
	
	Query query = entityManager.createQuery("delete from Sponsor where id=:id");
	query.setParameter("id", id);
	query.executeUpdate();
	
}
}
