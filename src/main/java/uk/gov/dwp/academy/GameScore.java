package uk.gov.dwp.academy;

import java.util.HashMap;
import java.util.Map;
import uk.gov.dwp.academy.logic.GameScoreInterface;
import uk.gov.dwp.academy.logic.GameState;
import uk.gov.dwp.academy.logic.GameStateInterface;

public class GameScore implements GameScoreInterface {

  private final GameStateInterface gameState;

  public GameScore(GameState gameState) {
    this.gameState = gameState;
  }

  @Override
  public int calculate() {

    Map<Integer, Integer> records = gameState.getRecord();
    int score = 0;
    // int frameRoll = 0
    // int pinsleft = 10
    // int frame
    int frameRoll = 0;
    int pinLeft = 10;
    for (int key : records.keySet()) {
      int pins = records.get(key);
      System.out.println("key "+key);
      System.out.println("value "+pins);
      System.out.println("roll "+frameRoll);
      if(frameRoll == 1){
        frameRoll = 0;
      }else{
        frameRoll = 1;
      }
      pinLeft = pinLeft - pins;
      System.out.println("pinLeft =" +pinLeft);
      if(pinLeft  == 0){
        score += records.get(key + 1);
        System.out.println("bonus spare");
      }
      if(key%2 == 0) {
        pinLeft = 10;
      }
      score += pins;
      System.out.println("score "+score);

      // if (frameRoll = 1 || pins == 10) {
      //   frameRoll = 0
      //   frame += 1
      // } else {
      //   frameRoll = 1
      //   pinsLeft -= pins
      // }
      // if (frame != 11) {
      // if (pinsLeft == 0) {
      // ----spare----
      //   score += records.get(key+1)
      // } else if (pins == 10) {
      // ----strike----
      //   score += records.get(key+1)+records.get(key+2)
      // }
      // }
      // if (frameRoll = 0) {
      //   pinsLeft = 10
      // }

    }

    return score;
  }
}
