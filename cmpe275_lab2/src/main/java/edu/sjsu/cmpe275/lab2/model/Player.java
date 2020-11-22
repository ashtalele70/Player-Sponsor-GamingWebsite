package edu.sjsu.cmpe275.lab2.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
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

  @Column(unique = true)
  private String email;

  @Column(nullable = true)
  private String description;

  @ManyToOne
  @JoinColumn(name = "sponsor_id", nullable = true)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","sponsor",
    "players"})
  private Sponsor sponsor;

  @ManyToMany
  @JoinTable(name = "opponent",
    joinColumns = { @JoinColumn(name = "id")},
    inverseJoinColumns = { @JoinColumn(name = "opponent_id")})
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","sponsor",
    "opponents"})
  private List<Player> opponents;

  public long getId() {
	return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public List<Player> getOpponents() {
    return opponents;
  }

  public void setOpponents(List<Player> opponents) {
    this.opponents = opponents;
  }
}
