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

  @Override
  public int calculate() {

    List<Integer> records = gameState.getRecord();
    int score = 0;
    int frameRoll = 0;
    int pinLeft = 10;

    for (int roll = 0; roll < records.size(); roll++) {

      int pins = records.get(roll);

      if (frameRoll == 1) {
        frameRoll = 0;
      } else {
        frameRoll = 1;
      }

      if (isStrike(frameRoll, pins)) {
        score += calculateStrikeScore(records, roll);

      }
      pinLeft = pinLeft - pins;
      if (isSpare(frameRoll, pinLeft)) {
        score += records.get(roll + 1);
      }
      pinLeft = frameReset(frameRoll, pinLeft);

      score += pins;
    }

    return score;
  }

  private int frameReset(int frameRoll, int pinLeft) {
    if (frameRoll == 0) {
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
    if (frameRoll == 1) {
      return 10 == pins;
    }
    return false;
  }

  private boolean isSpare(int frameRoll, int pinLeft) {

    if (frameRoll == 0) {
      return pinLeft == 0;
    }
    return false;
  }
}
