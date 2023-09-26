package uk.gov.dwp.academy;

import uk.gov.dwp.academy.logic.GameStateInterface;
import uk.gov.dwp.academy.tenpin.RollResponse;

public class PlayerGame {

  private final GameStateInterface gameState;
  private final GameScoreInterface gameScore;

  public PlayerGame(GameStateInterface gameState) {
    this.gameState = gameState;
    this.gameScore = gameScore;
  }

  public RollResponse roll(int i) {

    gameState.checkPinCount(i);
    gameState.recordRoll(i);
    gameScore.calculate();

    return new RollResponse(false);
  }
}
