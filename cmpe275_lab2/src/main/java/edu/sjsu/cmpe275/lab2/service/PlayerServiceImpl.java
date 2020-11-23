package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.dao.PlayerDao;
import edu.sjsu.cmpe275.lab2.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlayerServiceImpl implements PlayerService {

  @Autowired
  PlayerDao playerDao;

  /**
   * This is a method for getting player details by ID.
   * 
   * @param id id of the player
   * @return   deep Player object
   */
  @Override
  public Player getPlayerById(Long id) {
    return playerDao.getPlayerById(id);
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
  @Transactional
  public Player createPlayer(String firstname, String lastname, String email, String description, Long sponsorId) {
	  return playerDao.createPlayer(firstname, lastname, email, description, sponsorId);
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
  @Transactional
  public Player updatePlayer(Long id, String firstname, String lastname, String email, String description, Long sponsorId) {
	  return playerDao.updatePlayer(id, firstname, lastname, email, description, sponsorId);
  }
  
  /**
   * This is a method for deleting a player.
   * 
   * @param id id of the player to be deleted
   * @return   deep copy of the deleted Player object
   */
  @Override
  @Transactional
  public Player deletePlayer(Long id) {
	  return playerDao.deletePlayer(id);
  }
}
