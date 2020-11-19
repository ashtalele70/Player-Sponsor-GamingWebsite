package edu.sjsu.cmpe275.lab2.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sjsu.cmpe275.lab2.exception.PlayerNotFoundException;
import edu.sjsu.cmpe275.lab2.model.Opponent;
import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.model.Sponsor;

@Repository
public class OpponentDaoImpl implements OpponentDao {
	
	private EntityManager entityManager;
	 
	  @Autowired
	  public OpponentDaoImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}

	@Override
	public void deleteOpponent(Long id1, Long id2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOpponent(Long id1, Long id2) {
		
		Player player1 = entityManager.find(Player.class, id1);
		Player player2 = entityManager.find(Player.class, id2);
	    if(player1 == null || player2 == null) throw new PlayerNotFoundException("Player not found");
	    
	    else {
	    	
	    	Query query = entityManager.createQuery("select id from opponent where playerId =:id AND opponentId=:id2")
	    			.setParameter("id", id1)
	    			.setParameter("id2", id2);    
	    	int a = query.getFirstResult();
	    	if(a>0) ;
	    	else {
		Opponent opponent1 = new Opponent();
		Opponent opponent2 = new Opponent();
		
		
		opponent1.setPlayerId(id1);
		opponent1.setOpponentId(id2);
		opponent2.setPlayerId(id2);
		opponent2.setOpponentId(id1);
		Opponent dbOpponent1 = entityManager.merge(opponent1);
		Opponent dbOpponent2 = entityManager.merge(opponent2);
	    
	    }
	    }
		
	}
	
	
}
