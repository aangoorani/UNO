package com.company;

public class ActionCard extends Card{

    public ActionCard(String color, String name){
        this.color = color;
        this.name = name;
        switch (name) {
            case "2":
                value = 2;
                break;
            case "8":
                value = 8;
                break;
            case "10":
                value = 10;
                break;
            case "a":
                value = 11;
                break;
            case "b":
                value = 12;
                break;
            case "7":
                if (color.equals("black")) {
                    value = 15;
                } else {
                    value = 10;
                }
                break;
        }
    }

    public void action(){

    }

}
