package edu.sjsu.cmpe275.lab2.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.sjsu.cmpe275.lab2.exception.OpponentsDoNotExist;
import edu.sjsu.cmpe275.lab2.exception.OpponentsExistException;
import edu.sjsu.cmpe275.lab2.exception.PlayerNotFoundException;
import edu.sjsu.cmpe275.lab2.model.Opponent;
import edu.sjsu.cmpe275.lab2.model.Player;

@Repository
public class OpponentDaoImpl implements OpponentDao {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	public OpponentDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	/**
	 * This is a method for deleting the opponent relation between two players.
	 * 
	 * @param id1 id of player 1
	 * @param id2 id of player 2
	 * @return success text message
	 * 
	 */

	@Override
	public String deleteOpponent(Long id1, Long id2) {

		Player player1 = entityManager.find(Player.class, id1);
		Player player2 = entityManager.find(Player.class, id2);
		if (player1 == null || player2 == null)
			throw new PlayerNotFoundException("Player not found");

		else {
			List<Long> list = entityManager
					.createNativeQuery(
							"Select player_ID FROM opponent WHERE player_ID=:scrip and Opponent_ID = :prdate")
					.setParameter("scrip", id1).setParameter("prdate", id2).getResultList();
			if (list.isEmpty()) {
				throw new OpponentsDoNotExist("Opponents not found");

			} else {
				Query query = entityManager
						.createNativeQuery("delete  from opponent where player_id =:id1 and opponent_id=:id2")
						.setParameter("id1", id1).setParameter("id2", id2);
				;
				query.executeUpdate();

				Query query2 = entityManager
						.createNativeQuery("delete  from opponent where player_id =:id2 and opponent_id=:id1")
						.setParameter("id1", id1).setParameter("id2", id2);
				;
				query2.executeUpdate();
			}
		}
		return "Opponents deleted";

	}

	/**
	 * This is a method for adding two players as opponents.
	 * 
	 * @param id1 id of player 1
	 * @param id2 id of player 2
	 * @return success text message
	 * 
	 */

	@Override
	public String addOpponent(Long id1, Long id2) {

		Player player1 = entityManager.find(Player.class, id1);
		Player player2 = entityManager.find(Player.class, id2);
		if (player1 == null || player2 == null)
			throw new PlayerNotFoundException("Player not found");

		else {

			List<Long> list = entityManager
					.createNativeQuery(
							"Select player_ID FROM opponent WHERE player_ID=:scrip and Opponent_ID = :prdate")
					.setParameter("scrip", id1).setParameter("prdate", id2).getResultList();
			if (list.isEmpty()) {
				Opponent opponent1 = new Opponent();
				Opponent opponent2 = new Opponent();

				opponent1.setPlayerId(id1);
				opponent1.setOpponentId(id2);
				opponent2.setPlayerId(id2);
				opponent2.setOpponentId(id1);
				Opponent dbOpponent1 = entityManager.merge(opponent1);
				Opponent dbOpponent2 = entityManager.merge(opponent2);
			}

			else {

				throw new OpponentsExistException("Opponents exist");
			}
		}
		return "Opponents added";

	}

}