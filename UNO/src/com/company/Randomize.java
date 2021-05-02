package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Randomize {
   UnoSystem unoSystem = UnoSystem.getInstance();
   private static Randomize randomGenerator;
   private Random random;

   private Randomize(){
      random = new Random();

   }

   public static Randomize getInstance(){
      if (randomGenerator == null)
         randomGenerator = new Randomize();
      return randomGenerator;
   }

   public void giveCards(){
      for (int i = 0; i < unoSystem.getNumberOfPlayers(); i++) {
         Player player = unoSystem.getPlayers().get(i);
         for (int j = 1; j <= 7 ; j++) {
            int r = random.nextInt(unoSystem.getMiddleCards().size());
            Card card = unoSystem.getMiddleCards().get(r);
            unoSystem.getMiddleCards().remove(r);
         }
      }
   }

   public void setFirstCard(){
      int r = random.nextInt(unoSystem.getMiddleCards().size());
      Card card = unoSystem.getMiddleCards().get(r);
      while (card instanceof ActionCard){
          r = random.nextInt(unoSystem.getMiddleCards().size());
          card = unoSystem.getMiddleCards().get(r);
      }
      unoSystem.setLastCard(card);
   }

   public CircleList.Node startingPlayer(){
      int r = random.nextInt(unoSystem.getNumberOfPlayers());
      return unoSystem.getPlayers().getNode(r);
   }



}
