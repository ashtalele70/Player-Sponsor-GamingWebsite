package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.dao.OpponentDao;
import edu.sjsu.cmpe275.lab2.dao.PlayerDao;
import edu.sjsu.cmpe275.lab2.model.Opponent;
import edu.sjsu.cmpe275.lab2.model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OpponentServiceImpl implements OpponentService {

	@Autowired
	OpponentDao opponentDao;

	/**
	 * This is a method for deleting the opponent relation between two players.
	 * 
	 * @param id1 id of player 1
	 * @param id2 id of player 2
	 * @return success text message
	 * 
	 */
	@Override
	@Transactional
	public String deleteOpponent(Long id1, Long id2) {
		return opponentDao.deleteOpponent(id1, id2);

	}

	/**
	  * This is a method for adding two players as opponents.
	  * 
	  * @param id1 id of player 1
	  * @param id2 id of player 2
	  * @return    success text message
	  * 
	  */
	@Override
	@Transactional
	public String addOpponent(Long id1, Long id2) {
		return opponentDao.addOpponent(id1, id2);
	}

}