package uk.gov.dwp.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import uk.gov.dwp.academy.tenpin.RollResponse;

public class PlayerGameTest {

  @ParameterizedTest
  @CsvSource({"-1","11"})
  @DisplayName("Given an invalid pin then return outcome as false")
  public void givenInvalidPinReturnFalse(int input){
    PlayerGame playerGame = new PlayerGame();
    RollResponse rollResponse = playerGame.roll(input);
    assertEquals(false, rollResponse.success(), "should return false");
  }

}
