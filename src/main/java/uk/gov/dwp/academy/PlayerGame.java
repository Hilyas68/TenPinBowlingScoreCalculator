package uk.gov.dwp.academy;

import uk.gov.dwp.academy.logic.GameScoreInterface;
import uk.gov.dwp.academy.logic.GameStateInterface;
import uk.gov.dwp.academy.tenpin.RollResponse;

public class PlayerGame {

  private final GameStateInterface gameState;
  private final GameScoreInterface gameScore;

  public PlayerGame(GameStateInterface gameState, GameScoreInterface gameScore) {
    this.gameState = gameState;
    this.gameScore = gameScore;
  }

  public RollResponse roll(int pins) {

    gameState.checkPinCount(pins);
    gameState.recordRoll(pins);
    gameScore.calculate();

    return new RollResponse(false);
  }
}
