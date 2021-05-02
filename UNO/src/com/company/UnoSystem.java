package com.company;


import java.util.*;

public class UnoSystem {

    private static  UnoSystem unoSystem;
    private LinkedList <Card> allCards;
    private LinkedList <Card> middleCards;
    private Card lastCard;
    private CircleList players;
    private int numberOfPlayers;
    private CircleList.Node startingPlayer;
    private Randomize randomize;


    public CircleList.Node getStartingPlayer() {
        return startingPlayer;
    }


    private UnoSystem() {
        allCards = new LinkedList<>();
        middleCards = new LinkedList<>();
        players = new CircleList();
        setAllCards();
        middleCards.addAll(allCards);
        randomize = Randomize.getInstance();
        startingPlayer = randomize.startingPlayer();
    }


    public static UnoSystem getInstance(){
        if (unoSystem == null)
            unoSystem = new UnoSystem();
        return unoSystem;
    }

    public LinkedList<Card> getMiddleCards() {
        return middleCards;
    }

    public Card getLastCard() {
        return lastCard;
    }

    public void setAllCards() {
        setCard("black");
        setCard("blue");
        setCard("green");
        setCard("red");
    }

    public void setCard(String color) {
        for (int i = 2; i <= 10; i++) {
            if (!(i == 7 || i == 8 || i == 2 || i == 10)) {
                Card card = new NumberCard(color, String.format("%d", i));
                allCards.add(card);
            }else{
                Card card = new ActionCard(color,String.format("%d", i));
            }
        }

        Card card = new NumberCard(color, "c");
        Card card1 = new NumberCard(color, "d");
        allCards.add(card);
        allCards.add(card1);


        Card card2 = new ActionCard(color,"a");
        Card card3 = new ActionCard(color,"b");
        allCards.add(card2);
        allCards.add(card3);
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void addPlayer(Player player){
        players.add(player);
        numberOfPlayers++;
    }

    public void setLastCard(Card lastCard) {
        this.lastCard = lastCard;
    }

    public LinkedList<Card> getAllCards() {
        return allCards;
    }

    public CircleList getPlayers() {
        return players;
    }

    public void addToMiddleCard(Card card){
        if (card != null){
            middleCards.add(card);
        }
    }

    public boolean endGame(Player player){
        boolean flag = false;
        for (int i = 0; i < getNumberOfPlayers();i++) {
            Player p = players.get(i);
            if (p.score == 0){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void terminateGame(Player player) {
        if (endGame(player)) {
           List <Player> linkedList = players.toLinkedList();
           linkedList.sort(new Comparator<Player>() {
               @Override
               public int compare(Player o1, Player o2) {
                   return o1.getScore() - o2.getScore();
               }
           });
            for(Player p : linkedList){
                System.out.println(p.getName()+" : "+p.score);
            }
            }

        }

}
