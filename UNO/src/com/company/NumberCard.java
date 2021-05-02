package com.company;

public class NumberCard extends Card{
    UnoSystem unoSystem = UnoSystem.getInstance();
    public NumberCard(String color,String name){
        this.color = color;
        this.name = name;
        if (name.equals("c")){
            value = 12;
        }else if (name.equals("d")){
            value = 13;
        }else{
            value = Integer.parseInt(name);
        }
    }



}
