package com.edu.cnu.poker;

/**
 * Created by com on 2017-04-26.
 */
public enum Chart {
    LOYALSTRAIGHTFLUSH(0),
    BACKSTRAIGHTFLUSH(1),
    STRAIGHTFLUSH(2),
    FOURCARD(3),
    FULLHOUSE(4),
    FLUSH(5),
    MOUNTAIN(6),
    BACKSTRAIGHT(7),
    STRAIGHT(8),
    TRIPLE(9),
    TWOPAIR(10),
    ONEPAIR(11),
    TOP(12);
    private int priority;

    Chart(int priority){
        this.priority = priority;
    }
    public int getPriority(){
        return this.priority;
    }



}
