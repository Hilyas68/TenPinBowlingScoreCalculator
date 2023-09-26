package uk.gov.dwp.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.dwp.academy.logic.GameState;
import uk.gov.dwp.academy.logic.GameStateInterface;

@ExtendWith(MockitoExtension.class)
public class GameStateTest {

  @InjectMocks
  private HashMap<Integer, Integer> rollRecord;

  @ParameterizedTest
  @CsvSource({"0, 1"})
  @DisplayName("Given pin, record the roll and return frame id")
  public void givenPinRecordRollReturnFrame(int input, int expectedFrameId) {
    GameStateInterface gameState = new GameState();
    int frameId = gameState.recordRoll(input);
    assertEquals(expectedFrameId, frameId, "should return frame id");
  }

  @Test
  @DisplayName("Given a pin when the roll is recorded, confirm state")
  public void whenRollIsRecordedConfirmState() {
    gameState.recordRoll(8);
    Mockito.verify(rollRecord, times(1)).put(8);
  }

  // Given a new game
  // when two rolls
}
