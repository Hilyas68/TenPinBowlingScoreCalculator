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
      pinLeft = pinLeft - pins;

      if (pinLeft == 0) {
        score += records.get(roll + 1);
      }
      if (frameRoll == 0) {
        pinLeft = 10;
      }
      score += pins;

    }

    return score;
  }
}
