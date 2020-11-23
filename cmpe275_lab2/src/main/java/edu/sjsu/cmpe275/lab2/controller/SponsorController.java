package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.Sponsor;
import edu.sjsu.cmpe275.lab2.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SponsorController {

  @Autowired
  private SponsorService sponsorService;
  
 /**
  * This is a method for getting sponsor details by ID.
  * 
  * @param id id of the sponsor
  * @return   deep Sponsor object
  * 
  */
  @GetMapping("/sponsor/{id}")
  public Sponsor getSponsorById(@PathVariable Long id){
    return sponsorService.getSponsorById(id);
  }
  
 /**
  * This is a method for creating a sponsor.
  * The name parameter is mandatory.
  * 
  * @param name        name of the sponsor
  * @param description description of the sponsor
  * @param street      sponsor's street address
  * @param city        sponsor's city
  * @param state       sponsor's state
  * @param zip         sponsor's zipcode
  * @return            deep copy of the created Sponsor object
  * 
  */
  @PostMapping("/sponsor")
  public Sponsor createSponsor(@RequestParam("name") String name, @RequestParam(name="description", required=false)
  String description, @RequestParam(name="street",required=false) String street, @RequestParam(name="city",required=false) String city,
  @RequestParam(name="state",required=false) String state,@RequestParam(name="zip",required=false) String zipCode){
	   return sponsorService.createSponsor(name,description,street,city,state,zipCode);
  }
  
 /**
  * This is a method for deleting a sponsor.
  * 
  * @param id id of the sponsor
  * @return   deep copy of the deleted Sponsor object
  * 
  */
  @DeleteMapping("/sponsor/{id}")
  public Sponsor deleteSponsor(@PathVariable Long id) {
	   return sponsorService.deleteSponsor(id);
  }
  
  /**
   * This is a method for updating a sponsor.
   * The name parameter is mandatory.
   * 
   * @param name        name of the sponsor
   * @param description description of the sponsor
   * @param street      sponsor's street address
   * @param city        sponsor's city
   * @param state       sponsor's state
   * @param zip         sponsor's zipcode
   * @return            deep copy of the updated Sponsor object
   * 
   */
  @PutMapping("/sponsor/{id}")
  public Sponsor updateSponsor(@PathVariable Long id,@RequestParam("name") String name,@RequestParam(name="description", required=false) String description,
		  @RequestParam(name="street",required=false) String street, @RequestParam(name="city",required=false) String city,
		  @RequestParam(name="state",required=false) String state, @RequestParam(name="zip", required=false) String zipCode) {
	return sponsorService.updateSponsor(id,name,description,street,city,state,zipCode);
  }
  

}
