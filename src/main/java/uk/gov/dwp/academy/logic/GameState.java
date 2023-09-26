package uk.gov.dwp.academy.logic;

import uk.gov.dwp.academy.logic.GameStateInterface;

public class GameState implements GameStateInterface {

  @Override
  public boolean checkPinCount(int i) {
    return false;
  }

  @Override
  public int recordRoll(int i) {
    return 1;
  }
}
