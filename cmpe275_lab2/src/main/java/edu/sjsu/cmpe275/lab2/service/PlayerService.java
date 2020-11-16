package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.model.Player;

public interface PlayerService {

  public Player getPlayerById(Long id);
  
  public Player createPlayer(String firstname, String lastname, String email, String description, Long sponsorId);
  
  public Player updatePlayer(Long id, String firstname, String lastname, String email, String description, Long sponsorId);
  
  public void deletePlayer(Long id);
}
