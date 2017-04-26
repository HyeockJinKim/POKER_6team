package com.edu.cnu.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public String evaluate(List<Card> cardList) {
        boolean isFlush = flush(cardList);


        Map<Integer, Integer> rankMap = new HashMap<Integer, Integer>();
        for (Card card : cardList) {
            if (rankMap.containsKey(card.getRank())) {
                Integer count = rankMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                rankMap.put(card.getRank(), count);
            } else {
                rankMap.put(card.getRank(), new Integer(1));
            }
        }


        if (isFlush) {
            //로티플
            if (loyalstraightflush(rankMap)) return "LOYALSTRAIGHTFLUSH";
            //백스트레이트 플러쉬
            if (backstraightflush(rankMap)) return "BACKSTRAIGHTFLUSH";
            //스트레이트 플러쉬
            if (straightflush(rankMap)) return "STRAIGHTFLUSH";
        }

        //포카드
        fourcard(rankMap);

        //풀하우스

        //마운틴

        //백스트레이트

        //스트레이스

        //트리플
        triple(rankMap);

        //투 페어

        //원 페어

        //탑




        return "NOTHING";
    }


    private boolean flush(List<Card> cardList) {
        boolean isFlush = false;
        //enum 선언.

        Map<Suit, Integer> suitMap = new HashMap<Suit, Integer>();

        for (Card card : cardList) {
            if (suitMap.containsKey(card.getSuit())) {
                Integer count = suitMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                suitMap.put(card.getSuit(), count);
            } else {
                suitMap.put(card.getSuit(), new Integer(1));
            }
        }
        for (Suit key : suitMap.keySet()) {
            if (suitMap.get(key) == 5) {
                isFlush = true;
            }
        }

        return isFlush;
    }

    private boolean fourcard(Map<Integer, Integer> rankMap) {
        for (Integer key: rankMap.keySet()) {
            if (rankMap.get(key) == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean triple(Map<Integer, Integer> rankMap) {
        for (Integer key: rankMap.keySet()) {
            if (rankMap.get(key) == 3) {
                return true;
            }
        }
        return false;
    }





}
