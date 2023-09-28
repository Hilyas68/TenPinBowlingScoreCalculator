package uk.gov.dwp.academy.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uk.gov.dwp.academy.logic.GameScoreInterface;
import uk.gov.dwp.academy.logic.GameState;
import uk.gov.dwp.academy.logic.GameStateInterface;

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
    int score = 0;
    int frameRoll = SECOND;
    int pinLeft = 10;

    for (int roll = 0; roll < records.size(); roll++) {

      int pins = records.get(roll);

      if (frameRoll == FIRST) {
        frameRoll = SECOND;
      } else {
        frameRoll = FIRST;
      }

      pinLeft = pinLeft - pins;

      if (isStrike(frameRoll, pins)) {
        score += calculateStrikeScore(records, roll);

      }else if (isSpare(frameRoll, pinLeft)) {
        score += records.get(roll + 1);
      }

      pinLeft = frameReset(frameRoll, pinLeft);

      score += pins;
    }

    return score;
  }

  private int frameReset(int frameRoll, int pinLeft) {
    if (frameRoll == SECOND) {
      return 10;
    }
    return pinLeft;
  }

  private int calculateStrikeScore(List<Integer> records, int roll) {
    int score = 0;
    score += records.get(roll + 1);
    score += records.get(roll + 2);
    return score;
  }

  private boolean isStrike(int frameRoll, int pins) {
    if (frameRoll == FIRST) {
      return 10 == pins;
    }
    return false;
  }

  private boolean isSpare(int frameRoll, int pinLeft) {

    if (frameRoll == SECOND) {
      return pinLeft == 0;
    }
    return false;
  }
}
