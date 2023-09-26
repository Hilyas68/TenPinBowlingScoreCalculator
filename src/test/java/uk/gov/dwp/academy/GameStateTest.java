package uk.gov.dwp.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.dwp.academy.logic.GameState;
import uk.gov.dwp.academy.logic.GameStateInterface;

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
}
