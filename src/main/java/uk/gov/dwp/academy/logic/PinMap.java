package uk.gov.dwp.academy.logic;

import java.util.HashMap;

public class PinMap {
  private HashMap<Integer, Integer> record;

  public PinMap() {
    record = new HashMap<>();
  }

  public void put(int pins) {
    int size = record.size();
    record.put(size + 1, pins);
  }

  public HashMap<Integer, Integer> get() {
      return record;
  }
}
