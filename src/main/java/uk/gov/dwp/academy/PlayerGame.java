package uk.gov.dwp.academy;

import uk.gov.dwp.academy.logic.GameStateInterface;
import uk.gov.dwp.academy.tenpin.RollResponse;

public class PlayerGame {

  private final GameStateInterface gameState;

  public PlayerGame(GameStateInterface gameState) {
    this.gameState = gameState;
  }

  public RollResponse roll(int i) {

    gameState.checkPinCount(i);
    return new RollResponse(false);
  }
}
