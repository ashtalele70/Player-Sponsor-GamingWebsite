package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.exception.InvalidPlayerException;
import edu.sjsu.cmpe275.lab2.exception.PlayerEmailInvalidException;
import edu.sjsu.cmpe275.lab2.exception.PlayerNotFoundException;
import edu.sjsu.cmpe275.lab2.exception.SponsorNotFoundException;
import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.model.Sponsor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    if(player == null) throw new PlayerNotFoundException("Player Not Found");
    return player;
  }
  
  @Override
  public Player createPlayer(String firstname, String lastname, String email, String description, Long sponsorId) {
	
	if(firstname.isEmpty() || lastname.isEmpty() || email.isEmpty()) throw new InvalidPlayerException("Firstname, Lastname and Email cannot be empty");  
	  
	Player player = new Player();
	player.setFirstname(firstname);
	player.setLastname(lastname);
	player.setDescription(description);
	
	if(sponsorId != null) {
		Sponsor sponsor = entityManager.find(Sponsor.class, sponsorId);
		if(sponsor == null) throw new SponsorNotFoundException("Sponsor Not Found");
		player.setSponsor(sponsor);
	}
	
	Query query = entityManager.createQuery("from Player where email =: email")
			.setParameter("email", email);	
	Player playerWithSameEmail = (Player) query.getSingleResult();
	if(playerWithSameEmail != null) throw new PlayerEmailInvalidException("Email ID is already taken");
	
	player.setEmail(email);
	Player dbPlayer = entityManager.merge(player);

	return dbPlayer;
  }
  
  @Override
  public Player updatePlayer(Long id, String firstname, String lastname, String email, String description, Long sponsorId) {
	if(firstname.isEmpty() || lastname.isEmpty() || email.isEmpty()) throw new InvalidPlayerException("Firstname, Lastname and Email cannot be empty");
	
	Player player = entityManager.find(Player.class, id);
	if(player == null) throw new PlayerNotFoundException("Player Not Found");
	
	player.setFirstname(firstname);
	player.setLastname(lastname);
	if(description != null && !description.isEmpty()) {
		player.setDescription(description);
	}	
	if(sponsorId != null) {
		Sponsor sponsor = entityManager.find(Sponsor.class, sponsorId);
		if(sponsor == null) throw new SponsorNotFoundException("Sponsor Not Found");
		player.setSponsor(sponsor);
	}
	
	Query query = entityManager.createQuery("from Player where email =: email")
			.setParameter("email", email);
	Player playerWithSameEmail = (Player) query.getSingleResult();
	if(playerWithSameEmail != null && playerWithSameEmail.getId() != id) throw new PlayerEmailInvalidException("Email ID is already taken");
	
	player.setEmail(email);
	Player dbPlayer = entityManager.merge(player);
	
	return dbPlayer;
  }
  
  @Override
  public void deletePlayer(Long id) {
	  
	Player player = getPlayerById(id);
	if(player == null) throw new PlayerNotFoundException("Player Not Found");
	Query query = entityManager.createQuery("delete from Player where id =: id")
			.setParameter("id", id);
	query.executeUpdate();
  }
}
