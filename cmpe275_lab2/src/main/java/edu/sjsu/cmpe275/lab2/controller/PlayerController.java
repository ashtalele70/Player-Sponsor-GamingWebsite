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
  
 /**
  * This is a method for displaying a message on initial load.
  */
  @GetMapping("/")
  public String home() {
    return "Home Page";
  }
  
 /**
  * This is a method for getting player details by ID.
  * 
  * @param id id of the player
  * @return   deep Player object
  */
  @GetMapping("/player/{id}")
  public Player getPlayerById(@PathVariable Long id){
    return playerService.getPlayerById(id);
  }
  
 /**
  * This is a method for creating a player.
  * The first name, last name and email parameters are mandatory.
  * 
  * @param firstname   first name of the player
  * @param lastname    last name of the player
  * @param email       email ID of the player
  * @param description description of the player
  * @param sponsor     ID of an external sponsor for the player
  * @return            deep copy of the created Player object
  */
  @PostMapping("/player")
  @ResponseStatus(HttpStatus.OK)
  public Player createPlayer(@RequestParam(name = "firstname") String firstname, @RequestParam(name = "lastname") String lastname, @RequestParam(name = "email") String email, @RequestParam(name = "description", required = false) String description, @RequestParam(name = "sponsor", required = false) Long sponsorId) {
	return playerService.createPlayer(firstname, lastname, email, description, sponsorId); 
  }
  
 /**
  * This is a method for updating a player.
  * The first name, last name and email parameters are mandatory.
  * 
  * @param firstname   first name of the player
  * @param lastname    last name of the player
  * @param email       email ID of the player
  * @param description description of the player
  * @param sponsor     ID of an external sponsor for the player
  * @return            deep copy of the updated Player object
  */
  @PutMapping("/player/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Player updatePlayer(@PathVariable Long id, @RequestParam(name = "firstname") String firstname, @RequestParam(name = "lastname") String lastname, @RequestParam(name = "email") String email, @RequestParam(name = "description", required = false) String description, @RequestParam(name = "sponsor", required = false) Long sponsorId) {
	return playerService.updatePlayer(id, firstname, lastname, email, description, sponsorId);
  }
  
 /**
  * This is a method for deleting a player.
  * 
  * @param id id of the player to be deleted
  * @return   deep copy of the deleted Player object
  */
  @DeleteMapping("/player/{id}")
  public Player deletePlayer(@PathVariable Long id) {
	  return playerService.deletePlayer(id);
  }
}
