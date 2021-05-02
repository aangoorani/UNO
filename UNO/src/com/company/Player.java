package com.company;

import java.util.*;
public abstract class Player {

    protected String name;
    protected int score;
    protected LinkedList <Card> cards;
    protected boolean turn;

    public LinkedList<Card> getCards() {
        return cards;
    }

    public boolean isTurn() {
        return turn;
    }

    public Player(String name){
        this.name = name;
        score = 0;
        cards = new LinkedList<>();
        turn = false;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public LinkedList<Card> getCarts() {
        return cards;
    }

    public abstract void play(Card card);

    public abstract boolean checkValidPlay(Card card);

    public void takeCard(){}

    public boolean equals(Object o){
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Player))return false;
        Player player = (Player) o;
        return (player.name.equals(this.name));
    }

}
