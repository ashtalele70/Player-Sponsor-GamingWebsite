package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.model.Sponsor;

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
  public Player getPlayerById(Long id) {
    Session currentSession = entityManager.unwrap(Session.class);
    Query<Player> query = currentSession.createQuery("from Player where id =:" +
        " id", Player.class).setParameter("id", id);
    Player player = query.getSingleResult();
    return player;
  }
  
  @Override
  public Player createPlayer(String firstname, String lastname, String email, String description, Long sponsorId) {
	Session currentSession = entityManager.unwrap(Session.class);
	
	Player player = new Player();
	player.setFirstname(firstname);
	player.setLastname(lastname);
	player.setEmail(email);
	player.setDescription(description);
	
	Query<Sponsor> query = currentSession.createQuery("from Sponsor where id =: sponsorId", Sponsor.class)
			.setParameter("sponsorId", sponsorId);
	
	player.setSponsor(query.getSingleResult());
	
	currentSession.save(player);
	
	return new Player();
  }
}
