package edu.sjsu.cmpe275.lab2.controller;
import edu.sjsu.cmpe275.lab2.model.Opponent;
import edu.sjsu.cmpe275.lab2.model.Sponsor;
import edu.sjsu.cmpe275.lab2.service.OpponentService;
import edu.sjsu.cmpe275.lab2.service.SponsorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpponentController {
	
	@Autowired
	private OpponentService opponentService;
	
     /**
	  * This is a method for deleting the opponent relation between two players.
	  * 
	  * @param id1 id of player 1
	  * @param id2 id of player 2
	  * @return    success text message
	  * @throws    PlayerNotFoundException if either player does not exist 
	  * @throws    OpponentDoNotExistException if the two players are not opponents
	  */
	  @DeleteMapping("opponents/{id1}/{id2}")
	  public String deleteOpponent(@PathVariable (required = true) Long id1,@PathVariable (required = true) Long id2) {
		   return opponentService.deleteOpponent(id1,id2);
	  }
	  
	 /**
	  * This is a method for adding two players as opponents.
	  * 
	  * @param id1 id of player 1
	  * @param id2 id of player 2
	  * @return    success text message
	  * @throws    PlayerNotFoundException if either player does not exist 
	  * @throws    OpponentExistException if the two players are already opponents
	  */
	  @PutMapping("opponents/{id1}/{id2}")
	  @ResponseStatus(HttpStatus.OK)
	  public String addOpponent(@PathVariable (required = true) Long id1, @PathVariable (required = true) Long id2) {
		 
		  return  opponentService.addOpponent(id1,id2);
	  }

	
}
