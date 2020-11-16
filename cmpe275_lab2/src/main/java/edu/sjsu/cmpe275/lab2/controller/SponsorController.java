package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.Sponsor;
import edu.sjsu.cmpe275.lab2.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SponsorController {

  @Autowired
  private SponsorService sponsorService;

  @GetMapping("/sponsor/{id}")
  public Sponsor getSponsorById(@PathVariable Long id){
    return sponsorService.getSponsorById(id);
  }
  
  @PostMapping("/sponsor")
  public void createSponsor(@RequestParam("name") String name, @RequestParam(name="description", required=false)
  String description, @RequestParam(name="street",required=false) String street, @RequestParam(name="city",required=false) String city,
  @RequestParam(name="state",required=false) String state,@RequestParam(name="zip",required=false) String zipCode){
	   sponsorService.createSponsor(name,description,street,city,state,zipCode);
  }
  
  @DeleteMapping("/sponsor/{id}")
  public void deleteSponsor(@PathVariable Long id) {
	   sponsorService.deleteSponsor(id);
  }
}
