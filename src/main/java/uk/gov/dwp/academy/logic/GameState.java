package uk.gov.dwp.academy.logic;

import java.util.Map;

public class GameState implements GameStateInterface {

  private final PinMap rollRecord;
  private int frameState;
  private int rollsInFrame;

  public GameState() {
    rollRecord = new PinMap();
    frameState = 1;
    rollsInFrame = 0;
  }

  @Override
  public boolean checkPinCount(int i) {
    return false;
  }

  @Override
  public int recordRoll(int pins) {

    if (pins == 10) {
      frameState++;
      rollsInFrame = 0;
    } else {
      rollsInFrame++;
      if (rollsInFrame == 2) {
        frameState++;
        rollsInFrame = 0;
      }
    }

    rollRecord.put(pins);
    return frameState;
  }

  @Override
  public Map<Integer, Integer> getRecord() {
    return rollRecord.get();
  }
}
