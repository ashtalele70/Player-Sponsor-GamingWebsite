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

  @Override
  public Player getPlayerById(Long id) {
    return playerDao.getPlayerById(id);
  }
  
  @Override
  @Transactional
  public Player createPlayer(String firstname, String lastname, String email, String description, Long sponsorId) {
	  return playerDao.createPlayer(firstname, lastname, email, description, sponsorId);
  }
  
  @Override
  @Transactional
  public Player updatePlayer(Long id, String firstname, String lastname, String email, String description, Long sponsorId) {
	  return playerDao.updatePlayer(id, firstname, lastname, email, description, sponsorId);
  }
  
  @Override
  @Transactional
  public void deletePlayer(Long id) {
	  playerDao.deletePlayer(id);
  }
}
