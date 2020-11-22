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

	 

	@Override
	@Transactional
	public String deleteOpponent(Long id1, Long id2) {
	 return	opponentDao.deleteOpponent(id1, id2);
		
	}

	@Override
	@Transactional
	public String addOpponent(Long id1, Long id2) {
		return opponentDao.addOpponent(id1, id2);
		}
	  
}