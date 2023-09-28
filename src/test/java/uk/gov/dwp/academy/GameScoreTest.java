package uk.gov.dwp.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.dwp.academy.logic.GameScore;
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
  public void recordWithASpareReturnScore() {
    when(gameState.getRecord()).thenReturn(generateRecordWithSpare());
    assertEquals(35, gameScore.calculate(), "Should return score for a spare with bonus");
  }

  @Test
  @DisplayName("Given a record with a strike return score.")
  public void recordWithAStrikeReturnScore() {
    when(gameState.getRecord()).thenReturn(List.of(2, 5, 10, 4, 3, 6, 3, 8, 1));
    assertEquals(49, gameScore.calculate(), "should return score");
  }

  private List<Integer> generateRecordWithNoStrikeOrSpare() {
    return List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 5, 1, 0, 4, 3, 1, 2, 6);
  }

  private List<Integer> generateRecordWithSpare() {
    return List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 5, 5, 2, 4, 3, 1, 2, 6);
  }
}
