package edu.sjsu.cmpe275.lab2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sponsor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;


  @Column
  private String name;

  @Column
  private String description;

  private Address address;

  @OneToMany
  @JoinTable(name = "player",
    joinColumns = {@JoinColumn(name = "id", referencedColumnName =
      "sponsor_id")},
    inverseJoinColumns = {@JoinColumn(name = "sponsor_id",
      referencedColumnName = "id")})
  private List<Player> players;

}
