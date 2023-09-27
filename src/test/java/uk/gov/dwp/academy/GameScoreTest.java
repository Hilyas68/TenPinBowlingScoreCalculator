package uk.gov.dwp.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.dwp.academy.logic.GameState;
import uk.gov.dwp.academy.logic.GameStateInterface;
import uk.gov.dwp.academy.logic.PinMap;

@ExtendWith(MockitoExtension.class)
public class GameScoreTest {

  @Mock
  private GameState gameState;

  @Test
  @DisplayName("Given a roll then return score")
  public void calculateScore() {

    when(gameState.getRecord()).thenReturn(generateRecord());
    GameScore gameScore = new GameScore(gameState);
    int score = gameScore.calculate();
    assertEquals(5, score, "should return score 5");

  }

  private Map<Integer, Integer> generateRecord() {
    Map<Integer, Integer> record = new HashMap<>();
    record.put(1, 5);
    return record;
  }
}
