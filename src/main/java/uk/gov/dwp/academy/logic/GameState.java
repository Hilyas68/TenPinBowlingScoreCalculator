package uk.gov.dwp.academy.logic;

import java.util.HashMap;
import uk.gov.dwp.academy.logic.GameStateInterface;

public class GameState implements GameStateInterface {

  private HashMap<Integer, Integer> rollRecord;

  public GameState() {
    rollRecord = new HashMap<>();
  }

  @Override
  public boolean checkPinCount(int i) {
    return false;
  }

  @Override
  public int recordRoll(int i) {
    return 1;
  }
}
