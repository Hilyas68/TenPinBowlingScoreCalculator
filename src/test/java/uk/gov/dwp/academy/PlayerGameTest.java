package uk.gov.dwp.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.gov.dwp.academy.tenpin.RollResponse;

public class PlayerGameTest {

  @Test
  @DisplayName("Given an invalid pin then return outcome as false")
  public void givenInvalidPinReturnFalse(){
    PlayerGame playerGame = new PlayerGame();
    RollResponse rollResponse = playerGame.roll(-1);
    assertEquals(false, rollResponse.success(), "should return false");
  }

}
