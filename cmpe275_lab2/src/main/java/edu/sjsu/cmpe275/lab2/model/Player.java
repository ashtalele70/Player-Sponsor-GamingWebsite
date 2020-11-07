package edu.sjsu.cmpe275.lab2.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player")
@Setter
@Getter
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

  @Column
  private String description;

}
