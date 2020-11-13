package edu.sjsu.cmpe275.lab2.dao;

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
}
