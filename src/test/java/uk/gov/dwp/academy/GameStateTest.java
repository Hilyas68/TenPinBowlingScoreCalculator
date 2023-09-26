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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.dwp.academy.logic.GameState;
import uk.gov.dwp.academy.logic.GameStateInterface;
import uk.gov.dwp.academy.logic.PinMap;

@ExtendWith(MockitoExtension.class)
public class GameStateTest {

  @InjectMocks
  private GameState gameState;

  @Mock
  private PinMap rollRecord;

  @ParameterizedTest
  @CsvSource({"0, 1"})
  @DisplayName("Given pin, record the roll and return frame id")
  public void givenPinRecordRollReturnFrame(int input, int expectedFrameId) {
    int frameId = gameState.recordRoll(input);
    assertEquals(expectedFrameId, frameId, "should return frame id");
  }

  @Test
  @DisplayName("Given a pin when the roll is recorded, confirm state")
  public void whenRollIsRecordedConfirmState() {
    gameState.recordRoll(8);
    Mockito.verify(rollRecord, times(1)).put(8);
  }

  @Test
  @DisplayName("Given a roll that is not a strike, return frame as one")
  public void givenRollThatIsNotAStrikeReturnOne() {
    int result = gameState.recordRoll(6);
    assertEquals(1,result,"should return frame id as 1");
  }

  @Test
  @DisplayName("Given a roll that is a strike, return next frame")
  public void givenRollThatIsStrikeReturnNextFrame(){
    int result = gameState.recordRoll(10);
    assertEquals(2, result, "should return next frame");
  }

  // Given a start of frame x
  // when one roll - not a strike
  // then frame will be x

  // Given a start of frame x
  // when one roll - strike
  // then frame will be x+1

  // Given a start of frame x
  // when two rolls - not a strike
  // then frame will be x+1

  // Given a start of frame x
  // when two rolls - both strikes
  // then frame will be x+2

  // Given a start of frame 10
  // when two rolls - a spare
  // then frame will be 10

  // Given a start of frame 10
  // when one roll - a strike
  // then frame will be 10

  // Given a start of frame 10
  // when three rolls - a strike + 2 rolls
  // then frame will be 11

  // Given a start of frame 10
  // when three rolls - a spare + 1 roll
  // then frame will be 11

  // Given a start of frame 10
  // when two rolls - not a strike or spare
  // then frame will be 11

}
