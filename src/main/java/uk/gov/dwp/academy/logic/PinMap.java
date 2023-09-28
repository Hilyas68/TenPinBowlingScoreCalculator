package uk.gov.dwp.academy.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PinMap {

  private List<Integer> record;

  public PinMap() {
    record = new ArrayList<>();
  }

  public void put(int pins) {
    int size = record.size();
    record.add(pins);
  }

  public List<Integer> get() {
    return record;
  }
}
