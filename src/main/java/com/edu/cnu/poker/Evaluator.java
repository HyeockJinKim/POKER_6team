package com.edu.cnu.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public String evaluate(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }
        }

        for (Suit key : tempMap.keySet()) {
            if (tempMap.get(key) == 5) {
                return "FLUSH";
            }
        }
        return "NOTHING";
    }

    public boolean straight(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }
        }
        int c[] = new int[13];
        int count = 0;
        for (Suit key : tempMap.keySet()) {
            c[tempMap.get(key)]++;
        }


        for (int i = 1; i <= 13; i++) {
            if (c[i] == 1)
                count++;
            else
                count = 0;
        }
        if (count == 5)
            return true;
        else
            return false;
    }
    public boolean backstraight(List<Card> cardList){
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }
        }
        int c[] = new int[14];
        int count = 0;
        for (Suit key : tempMap.keySet()) {
            c[tempMap.get(key)]++;
        }
        if(c[1]==1){
            for (int i = 2; i <= 5; i++) {
                if (c[i] != 1)
                   return false;
            }
        }
        else
            return false;

       return true;

    }

}