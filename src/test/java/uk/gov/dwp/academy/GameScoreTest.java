package uk.gov.dwp.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.dwp.academy.logic.GameState;

@ExtendWith(MockitoExtension.class)
public class GameScoreTest {

  @Mock
  private GameState gameState;
  private GameScore gameScore;

  @BeforeEach
  public void setup() {
    gameScore = new GameScore(gameState);
  }

  @Test
  @DisplayName("Given no record then return zero")
  public void givenNoRecordReturnZero() {

    assertEquals(0, gameScore.calculate(), "should return score zero");
  }

  @Test
  @DisplayName("Given record with no strikes or spare return the cumulative score")
  public void recordWithNoStrikeOrSpare() {

    when(gameState.getRecord()).thenReturn(generateRecordWithNoStrikeOrSpare());
    assertEquals(27, gameScore.calculate(), "Should return the score for two rolls.");
  }

  @Test
  @DisplayName("Given record with a spare return cumulative score")
  public void recordWithASpareReturnScore(){
    when(gameState.getRecord()).thenReturn(generateRecordWithSpare());
    assertEquals(35, gameScore.calculate(), "Should return score for a spare with bonus");
  }

  private Map<Integer, Integer> generateRecordWithNoStrikeOrSpare() {
    Map<Integer, Integer> record = new HashMap<>();
    record.put(1, 2);
    record.put(2, 3);
    record.put(3, 5);
    record.put(4, 1);
    record.put(5, 0);
    record.put(6, 4);
    record.put(7, 3);
    record.put(8, 1);
    record.put(9, 2);
    record.put(10, 6);
    return record;
  }

  private Map<Integer, Integer> generateRecordWithSpare() {
    Map<Integer, Integer> record = new HashMap<>();
    record.put(1, 5);
    record.put(2, 5);
    record.put(3, 3);
    return record;
  }
}
