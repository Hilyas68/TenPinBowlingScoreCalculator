package uk.gov.dwp.academy;

import java.util.HashMap;
import java.util.Map;
import uk.gov.dwp.academy.logic.GameScoreInterface;
import uk.gov.dwp.academy.logic.GameState;
import uk.gov.dwp.academy.logic.GameStateInterface;
import uk.gov.dwp.academy.logic.PinMap;

public class GameScore implements GameScoreInterface {

  private final GameStateInterface gameState;

  public GameScore(GameState gameState) {
    this.gameState = gameState;
  }

  @Override
  public int calculate() {

    Map<Integer, Integer> records = gameState.getRecord();
    int score = 0;
    for(int key : records.keySet()){
      score += records.get(key);
    }

    return score;
  }
}
