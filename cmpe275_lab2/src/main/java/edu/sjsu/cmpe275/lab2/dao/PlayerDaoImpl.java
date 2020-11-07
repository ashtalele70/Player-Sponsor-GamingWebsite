package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.model.Player;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PlayerDaoImpl implements PlayerDao {

  @Autowired
  private EntityManager entityManager;

  @Override
  public Player getPlayerId(Long id) {
    Session currentSession = entityManager.unwrap(Session.class);
    Query<Player> query = currentSession.createQuery("from Player where id =:" +
        " id", Player.class).setParameter("id", id);
    Player player = query.getSingleResult();
    return player;
  }
}
