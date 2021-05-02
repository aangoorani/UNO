package com.company;

public class Human extends Player{
    UnoSystem unoSystem = UnoSystem.getInstance();
    public Human(String name){
        super(name);
    }



    public void play(Card card) {
        if (checkValidPlay(card)){
            Card previous = unoSystem.getLastCard();
            unoSystem.addToMiddleCard(previous);
            unoSystem.setLastCard(card);
            score -= card.value;
            cards.remove(card);
            if (card instanceof ActionCard){

            }
        }
    }

    public boolean checkValidPlay(Card card) {
        return card.color.equals(unoSystem.getLastCard().color) || card.getName().equals(unoSystem.getLastCard().name);
    }
}
