package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.model.Sponsor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PlayerDaoImpl implements PlayerDao {

  private EntityManager entityManager;

  @Autowired
  public PlayerDaoImpl(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }


  @Override
  public Player getPlayerById(Long id) {
    Player player = entityManager.find(Player.class, id);
    return player;
  }
  
  @Override
  public Player createPlayer(String firstname, String lastname, String email, String description, Long sponsorId) {
	
	Player player = new Player();
	player.setFirstname(firstname);
	player.setLastname(lastname);
	player.setEmail(email);
	player.setDescription(description);

	Sponsor sponsor = entityManager.find(Sponsor.class, sponsorId);
	player.setSponsor(sponsor);

	Player dbPlayer = entityManager.merge(player);

	return dbPlayer;
  }
}
