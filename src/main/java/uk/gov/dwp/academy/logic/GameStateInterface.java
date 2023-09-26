package uk.gov.dwp.academy.logic;

import java.util.Map;

public interface GameStateInterface {

  boolean checkPinCount(int i);

  int recordRoll(int i);

  Map<Integer, Integer> getRecord();

  int getInitialFrameState();
}
