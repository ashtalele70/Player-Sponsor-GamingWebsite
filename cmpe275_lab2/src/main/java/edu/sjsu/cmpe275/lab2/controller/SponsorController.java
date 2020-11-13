package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.Sponsor;
import edu.sjsu.cmpe275.lab2.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SponsorController {

  @Autowired
  private SponsorService sponsorService;

  @GetMapping("/sponsor/{id}")
  public Sponsor getSponsorById(@PathVariable Long id){
    return sponsorService.getSponsorById(id);
  }

}
