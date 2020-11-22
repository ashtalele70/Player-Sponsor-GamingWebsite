package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.model.Opponent;

public interface OpponentService {

  public String deleteOpponent(Long id1,Long id2);
   
  public String addOpponent(Long id1,Long id2);
}