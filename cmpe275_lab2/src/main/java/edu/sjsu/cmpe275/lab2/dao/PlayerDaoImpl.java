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

  /**
   * This is a method for getting player details by ID.
   * 
   * @param id id of the player
   * @return   deep Player object
   */
  @Override
  public Player getPlayerById(Long id) {
    Player player = entityManager.find(Player.class, id);
    if(player == null) throw new PlayerNotFoundException("Player Not Found");
    return player;
  }
  
  /**
   * This is a method for creating a player.
   * The first name, last name and email parameters are mandatory.
   * 
   * @param firstname   first name of the player
   * @param lastname    last name of the player
   * @param email       email ID of the player
   * @param description description of the player
   * @param sponsor     ID of an external sponsor for the player
   * @return            deep copy of the created Player object
   */
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
	if(!query.getResultList().isEmpty() && query.getSingleResult() != null) {
		Player playerWithSameEmail = (Player) query.getSingleResult();
		if(playerWithSameEmail != null) throw new PlayerEmailInvalidException("Email ID is already taken");
	}

	player.setEmail(email);
	Player dbPlayer = entityManager.merge(player);

	return dbPlayer;
  }
  
  /**
   * This is a method for updating a player.
   * The first name, last name and email parameters are mandatory.
   * 
   * @param firstname   first name of the player
   * @param lastname    last name of the player
   * @param email       email ID of the player
   * @param description description of the player
   * @param sponsor     ID of an external sponsor for the player
   * @return            deep copy of the updated Player object
   */
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
	if(!query.getResultList().isEmpty() && query.getSingleResult() != null) {
		Player playerWithSameEmail = (Player) query.getSingleResult();
		if(playerWithSameEmail != null && playerWithSameEmail.getId() != id) throw new PlayerEmailInvalidException("Email ID is already taken");
	}
	
	player.setEmail(email);
	Player dbPlayer = entityManager.merge(player);
	
	return dbPlayer;
  }
  
  /**
   * This is a method for deleting a player.
   * 
   * @param id id of the player to be deleted
   * @return   deep copy of the deleted Player object
   */
  @Override
  public Player deletePlayer(Long id) {

		Player player = getPlayerById(id);
		if(player == null) throw new PlayerNotFoundException("Player Not Found");
		Query query = entityManager.createQuery("delete from Player where id =: id")
				.setParameter("id", id);
				query.executeUpdate();

			return player;
  }
}
