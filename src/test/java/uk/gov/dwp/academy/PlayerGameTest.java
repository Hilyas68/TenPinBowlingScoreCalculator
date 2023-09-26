package uk.gov.dwp.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import uk.gov.dwp.academy.logic.GameStateInterface;
import uk.gov.dwp.academy.tenpin.RollResponse;

public class PlayerGameTest {

  @ParameterizedTest
  @CsvSource({"-1", "11"})
  @DisplayName("Given an invalid pin then return outcome as false")
  public void givenInvalidPinReturnFalse(int input) {
    GameStateInterface gameState = Mockito.mock(GameStateInterface.class);
    PlayerGame playerGame = new PlayerGame(gameState);
    RollResponse rollResponse = playerGame.roll(input);
    assertEquals(false, rollResponse.success(), "should return false");
  }

  @Test
  @DisplayName("Given a valid pin then checkPinCount is called")
  public void givenValidCheckPinCountIsCalled() {
    GameStateInterface gameState = Mockito.mock(GameStateInterface.class);
    when(gameState.checkPinCount(0)).thenReturn(true);
    PlayerGame playerGame = new PlayerGame(gameState);
    RollResponse rollResponse = playerGame.roll(0);

    verify(gameState, times(1)).checkPinCount(0);
  }
}
