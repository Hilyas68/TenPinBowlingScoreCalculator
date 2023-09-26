package uk.gov.dwp.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import uk.gov.dwp.academy.logic.GameStateInterface;
import uk.gov.dwp.academy.tenpin.RollResponse;

public class PlayerGameTest {

  @Mock
  private GameStateInterface gameState;
  private PlayerGame playerGame;

  @BeforeEach
  public void setup() {
    playerGame = new PlayerGame(gameState);
  }

  @ParameterizedTest
  @CsvSource({"-1", "11"})
  @DisplayName("Given an invalid pin then return outcome as false")
  public void givenInvalidPinReturnFalse(int input) {
    RollResponse rollResponse = playerGame.roll(input);
    assertEquals(false, rollResponse.success(), "should return false");
  }

  @Test
  @DisplayName("Given a valid pin then checkPinCount is called")
  public void givenValidCheckPinCountIsCalled() {
    when(gameState.checkPinCount(0)).thenReturn(true);
    playerGame.roll(0);

    verify(gameState, times(1)).checkPinCount(0);
  }
}
