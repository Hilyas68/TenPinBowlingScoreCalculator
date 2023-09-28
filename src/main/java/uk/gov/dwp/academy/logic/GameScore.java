package uk.gov.dwp.academy.logic;

import java.util.List;

public class GameScore implements GameScoreInterface {

  private final GameStateInterface gameState;

  public GameScore(GameState gameState) {
    this.gameState = gameState;
  }

  private static final int FIRST = 1;
  private static final int SECOND = 0;

  @Override
  public int calculate() {

    List<Integer> records = gameState.getRecord();

    if (records.isEmpty()) {
      return 0;
    }
    int score = 0;
    int frameCount = 0;
    int roll = 0;

    while (frameCount < 10) {

      int pins = records.get(roll);

      if (isStrike(roll, records)) {
        score += addStrikeBonus(records, roll);

      } else if (isSpare(roll, records)) {
        score += records.get(roll + 2);
      }

      if (frameCount == 9 && isStrike(roll, records)) {
        score += pins;
      } else {
        int pinsRoll = records.get(roll + 1);
        score += pins + pinsRoll;
      }

      roll = roll + 2;
      frameCount++;
    }

  }

  private int addStrikeBonus(List<Integer> records, int roll) {
    return records.get(roll + 1) + records.get(roll + 2);
  }

  private boolean isStrike(int roll, List<Integer> records) {
    return 10 == records.get(roll);
  }

  private boolean isSpare(int roll, List<Integer> records) {

    return records.get(roll) + records.get(roll + 1) == 10;
  }
}
