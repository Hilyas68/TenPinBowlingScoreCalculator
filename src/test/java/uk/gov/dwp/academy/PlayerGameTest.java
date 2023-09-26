package uk.gov.dwp.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import uk.gov.dwp.academy.logic.GameStateInterface;
import uk.gov.dwp.academy.tenpin.RollResponse;

@ExtendWith(MockitoExtension.class)
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

  @ParameterizedTest
  @CsvSource({"0", "10"})
  @DisplayName("Given a valid pin then checkPinCount is called")
  public void givenValidCheckPinCountIsCalled(int input) {
    when(gameState.checkPinCount(input)).thenReturn(true);
    playerGame.roll(input);

    verify(gameState, times(1)).checkPinCount(anyInt());
  }
}
