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

        //포카드
        fourcard(rankMap);

        //풀하우스

        //마운틴 & 로티플

        //백스트레이트 & 백스트레이트 플러쉬

        //스트레이스 & 스트레이트 플러쉬

        //트리플
        triple(rankMap);

        //투 페어
        twopair(rankMap);
        //원 페어
        onepair(rankMap);
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

    private boolean onepair(Map<Integer, Integer> rankMap) {
        for (Integer key: rankMap.keySet()) {
            if (rankMap.get(key) == 2) {
                return true;
            }
        }
        return false;
    }
    private boolean twopair(Map<Integer, Integer> rankMap) {
        int count = 0;
        for (Integer key: rankMap.keySet()) {
            if (rankMap.get(key) == 2) {
                count++;
            }
        }
        if (count >= 2) {
            return true;
        }
        return false;
    }


}
