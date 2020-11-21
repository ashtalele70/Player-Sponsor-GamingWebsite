package edu.sjsu.cmpe275.lab2.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "opponent")
public class Opponent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;
  @Column
  private long player_id;

  @Column
  private long opponent_id;



  public long getId() {
	return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getPlayerId() {
	return player_id;
  }

  public void setPlayerId(Long player_id) {
    this.player_id = player_id;
  }
  
  public long getOpponentId() {
		return opponent_id;
	  }

public void setOpponentId(Long opponent_id) {
	    this.opponent_id = opponent_id;
	  }
}
