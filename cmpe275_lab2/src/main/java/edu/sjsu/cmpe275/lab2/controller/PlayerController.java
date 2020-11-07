package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {

  @Autowired
  private PlayerService playerService;

  @GetMapping("/")
  public String home() {
    return "Home page";
  }

  @GetMapping("/player/{id}")
  public Player getPlayerId(@PathVariable Long id){
    return playerService.getPlayerId(id);
  }

}
