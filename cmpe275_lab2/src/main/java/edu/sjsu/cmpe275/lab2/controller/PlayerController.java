package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
