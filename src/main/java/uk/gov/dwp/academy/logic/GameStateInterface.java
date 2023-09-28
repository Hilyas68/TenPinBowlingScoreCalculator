package uk.gov.dwp.academy.logic;

import java.util.List;
import java.util.Map;

public interface GameStateInterface {

  boolean checkPinCount(int i);

  int recordRoll(int i);

  List<Integer> getRecord();
}
