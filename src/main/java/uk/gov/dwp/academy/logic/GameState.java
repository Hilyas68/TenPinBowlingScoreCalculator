package uk.gov.dwp.academy.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameState implements GameStateInterface {

  public static final int STRIKE = 10;
//  private PinMap rollRecord;
  private int frameState;
  private List<Integer> rollRecord;
  private int rollsInFrame;
  private int pinsCount;

  public GameState() {
    rollRecord = new ArrayList<>();
    frameState = 1;
    rollsInFrame = 0;
    pinsCount = 0;
  }

  public GameState(int frameState) {
    rollRecord = new ArrayList<>();
    this.frameState = frameState;
    rollsInFrame = 0;
    pinsCount = 0;
  }

  @Override
  public boolean checkPinCount(int i) {
    return false;
  }

  @Override
  public int recordRoll(int pins) {

    if (frameState < 10) {
      if (pins == STRIKE) {
        frameState++;
        rollsInFrame = 0;
      } else {
        rollsInFrame++;
        if (rollsInFrame == 2) {
          frameState++;
          rollsInFrame = 0;
        }
      }
    } else {
      pinsCount += pins;
      if(rollsInFrame > 0) {
        if (isNotSpare()) {
          frameState++;
        } else if (rollsInFrame == 2) {
          frameState++;
        }
      }

      rollsInFrame++;
    }

    rollRecord.add(pins);
    return frameState;
  }

  private boolean isNotSpare() {
    return rollsInFrame == 1 && pinsCount < 10;
  }

  @Override
  public List<Integer> getRecord() {
    return rollRecord;
  }
}
