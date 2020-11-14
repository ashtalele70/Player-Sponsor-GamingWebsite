package edu.sjsu.cmpe275.lab2.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "player")
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;
  @Column
  private String firstname;

  @Column
  private String lastname;

  @Column
  private String email;

  @Column(nullable=true)
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sponsor_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//  @JoinTable(name = "sponsor",
//    joinColumns = {@JoinColumn(name = "sponsor_id", referencedColumnName =
//      "id")})
//    inverseJoinColumns = {@JoinColumn(name = "id",
//      referencedColumnName = "sponsor_id")})
  private Sponsor sponsor;

  public long getId() {
	return id;
  }

  public String getFirstname() {
	return firstname;
  }

  public void setFirstname(String firstname) {
	this.firstname = firstname;
  }

  public String getLastname() {
	return lastname;
  }

  public void setLastname(String lastname) {
	this.lastname = lastname;
  }

  public String getEmail() {
	return email;
  }

  public void setEmail(String email) {
	this.email = email;
  }

  public String getDescription() {
	return description;
  }

  public void setDescription(String description) {
	this.description = description;
  }

  public Sponsor getSponsor() {
	return sponsor;
  }

  public void setSponsor(Sponsor sponsor) {
	this.sponsor = sponsor;
  }

//  @OneToMany
//  @JoinTable(name = "opponents",
//    joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
//    inverseJoinColumns = {@JoinColumn(name = "player_id2",
//      referencedColumnName = "player_id2")})
//  private List<Player> opponents;
  
  

}
