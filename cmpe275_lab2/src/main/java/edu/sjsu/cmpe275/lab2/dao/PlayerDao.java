package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.model.Player;

public interface PlayerDao {

  Player getPlayerById(Long id);
  
  Player createPlayer(String firstname, String lastname, String email, String description, Long sponsorId);
}
