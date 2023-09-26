package uk.gov.dwp.academy.logic;

import java.util.Map;

public class GameState implements GameStateInterface {

  private PinMap rollRecord;
  private int frameState;

  public GameState() {
    rollRecord = new PinMap();
    frameState = 1;
  }

  @Override
  public boolean checkPinCount(int i) {
    return false;
  }

  @Override
  public int recordRoll(int pins) {
    if (pins == 10) {
      frameState++;
    }
    rollRecord.put(pins);
    return frameState;
  }

  @Override
  public Map<Integer, Integer> getRecord() {
    return rollRecord.get();
  }
}
