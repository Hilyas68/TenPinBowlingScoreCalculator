package uk.gov.dwp.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.gov.dwp.academy.logic.GameState;
import uk.gov.dwp.academy.logic.GameStateInterface;

public class GameStateTest {

  @Test
  @DisplayName("Given pin, record the roll ans return frame id")
  public void givenPinRecordRollReturnFrame(){
    GameStateInterface gameState = new GameState();
    int frameId  = gameState.recordRoll(0);
    assertEquals(1, frameId, "should return frame id 1");
  }
}
