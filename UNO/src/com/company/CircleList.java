package com.company;

import java.util.LinkedList;
import java.util.Stack;

public class CircleList {
    private Node head;
    private Node tail;
    boolean reversed = false;
    private int size;

    static class Node{
        Player player;
        Node next;
        Node prev;

        public Node(Player player){
            this.player = player;
        }

        public Player getNextPlayer() {
            return this.next.player;
        }

        public Player getPrevPlayer(){
            return this.prev.player;
        }
    }

    public void add(Player player){
        Node newNode = new Node(player);
        if (head == null){
            head = newNode;
            tail = head;
            head.next = tail;
            tail.prev = head;
        }else {
            Node last = tail;
            tail.next = newNode;
            tail = tail.next;
            tail.next = head;
            tail.prev = last;
            head.prev = tail;
        }
        size++;
    }

    public void print(){
       Node cur = head;
       do {
           System.out.print(cur.player.getName()+" -> ");
           cur = cur.next;
       }while (cur != head);
    }

    public void clear(){
        head = null;
        tail = null;
    }

    public Player get(int i){
        i = i % size;
        Node cur = head;
        for (int j = 0; j < i ; j++) {
            cur = cur.next;
        }
        return cur.player;
    }

    public Node getNode(int index){
        index = index % size;
        Node cur = head;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public int getSize(){
        return this.size;
    }

    public LinkedList<Player> toLinkedList(){
        LinkedList <Player> linkedList = new LinkedList<>();
        Node cur = head;
        do{
            linkedList.add(cur.player);
            cur = cur.next;
        }while (cur != head);
        return linkedList;
    }

}
