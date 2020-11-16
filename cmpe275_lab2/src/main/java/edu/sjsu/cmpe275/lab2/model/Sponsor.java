package edu.sjsu.cmpe275.lab2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "sponsor")
public class Sponsor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;

  @Column
  private String name;

  @Column
  private String description;
  
  @Embedded
  private Address address;

  @OneToMany(mappedBy = "sponsor")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","sponsor"})
  private List<Player> players;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }
}
