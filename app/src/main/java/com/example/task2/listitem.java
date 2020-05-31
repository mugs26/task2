package com.example.task2;

public class listitem {
    private String head;
    private int score;

    public listitem(String head,int score) {
        this.head = head;
        this.score=score ;
    }

    public String getHead() {
        return head;
    }

    public int getScore() {
        return score;
    }
}