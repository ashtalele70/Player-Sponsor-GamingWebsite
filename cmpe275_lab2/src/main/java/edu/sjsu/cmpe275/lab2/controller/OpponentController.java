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
	
	@DeleteMapping("opponents/{id1}/{id2}")
	  public void deleteOpponent(@PathVariable Long id1,@PathVariable Long id2) {
		    opponentService.deleteOpponent(id1,id2);
	  }
	  
	  @PutMapping("opponents/{id1}/{id2}")
	  @ResponseStatus(HttpStatus.OK)
	  public void addOpponent(@PathVariable Long id1, @PathVariable Long id2) {
		 
		    opponentService.addOpponent(id1,id2);
	  }

	
}
