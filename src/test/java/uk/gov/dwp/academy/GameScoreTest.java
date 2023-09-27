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
  @DisplayName("Given a roll then return score")
  public void calculateScore() {

    when(gameState.getRecord()).thenReturn(generateRecordForSingleRoll());
    assertEquals(5, gameScore.calculate(), "should return score 5");
  }

  @Test
  @DisplayName("Given two rolls return the score")
  public void givenTwoRollsReturnScore() {

    when(gameState.getRecord()).thenReturn(generateRecordForTwoRolls());
    assertEquals(8, gameScore.calculate(), "Should return the score for two rolls.");
  }

  private Map<Integer, Integer> generateRecordForSingleRoll() {
    Map<Integer, Integer> record = new HashMap<>();
    record.put(1, 5);
    return record;
  }

  private Map<Integer, Integer> generateRecordForTwoRolls() {
    Map<Integer, Integer> record = new HashMap<>();
    record.put(1, 5);
    record.put(2, 3);
    return record;
  }
}
