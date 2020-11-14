package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.dao.PlayerDao;
import edu.sjsu.cmpe275.lab2.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

  @Autowired
  PlayerDao playerDao;

  @Override
  public Player getPlayerById(Long id) {
    return playerDao.getPlayerById(id);
  }
  
  @Override
  public Player createPlayer(String firstname, String lastname, String email, String description, Long sponsorId) {
	  return playerDao.createPlayer(firstname, lastname, email, description, sponsorId);
  }
}
