package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class PlayerController {

  @Autowired
  private PlayerService playerService;

  @GetMapping("/")
  public String home() {
    return "Home page";
  }

  @GetMapping("/player/{id}")
  public Player getPlayerById(@PathVariable Long id){
    return playerService.getPlayerById(id);
  }
  
  @PostMapping("/player")
  @ResponseStatus(HttpStatus.OK)
  public Player createPlayer(@RequestParam(name = "firstname") String firstname, @RequestParam(name = "lastname") String lastname, @RequestParam(name = "email") String email, @RequestParam(name = "description", required = false) String description, @RequestParam(name = "sponsor", required = false) Long sponsorId) {
	return playerService.createPlayer(firstname, lastname, email, description, sponsorId); 
  }
  
  @PutMapping("/player/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Player updatePlayer(@PathVariable Long id, @RequestParam(name = "firstname") String firstname, @RequestParam(name = "lastname") String lastname, @RequestParam(name = "email") String email, @RequestParam(name = "description", required = false) String description, @RequestParam(name = "sponsor", required = false) Long sponsorId) {
	return playerService.updatePlayer(id, firstname, lastname, email, description, sponsorId);
  }
  
  @DeleteMapping("/player/{id}")
  public void deletePlayer(@PathVariable Long id) {
	  playerService.deletePlayer(id);
  }

}
