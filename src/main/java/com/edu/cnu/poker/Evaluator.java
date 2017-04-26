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

        boolean isMountain = mountain(rankMap);
        boolean isStraight = straight(rankMap);
        boolean isBackstraight = backstraight(rankMap);

        if (isFlush) {
            //로티플
            if ( isMountain ) return "LOYALSTRAIGHTFLUSH";
            //백스트레이트 플러쉬
            if ( isStraight ) return "BACKSTRAIGHTFLUSH";
            //스트레이트 플러쉬
            if ( isBackstraight ) return "STRAIGHTFLUSH";
        }

        //포카드
        if ( fourcard(rankMap) ) return "FOURCARD";

        //풀하우스
        if ( fullhouse(rankMap) ) return "FULLHOUSE";

        //마운틴
        if ( isMountain ) return "MOUNTAIN";

        //백스트레이트
        if ( isBackstraight ) return "BACKSTRAIGHT";

        //스트레이스
        if ( isStraight ) return "STRAIGHT";

        //트리플
        if ( triple(rankMap) ) return "TRIPLE";

        //투 페어

        if ( twopair(rankMap) ) return "TWOPAIR";

        //원 페어
        if ( onepair(rankMap) ) return "ONEPAIR";

        //탑
        return "TOP";

    }


    public boolean straight(Map<Integer,Integer> rankMap) {
        int count=0;
        for (Integer key:rankMap.keySet()) {
            if (rankMap.get(key) == 1)
                count++;
            else
                count=0;

        }
        if(count==5)
            return true;
        else
            return false;
    }
    public boolean backstraight(Map<Integer,Integer> rankMap){

       if (rankMap.get(1)== 1){
           for(int i=2;i<=5;i++)
                if(rankMap.get(i)!=1)
                    return false;
        }
        else
            return false;

       return true;


    }

}


    private boolean flush(List<Card> cardList) {
        boolean isFlush = false;

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

    private boolean mountain(List<Card> cardList) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        for (Card card : cardList) {
                tempMap.put(card.getRank(), new Integer(1));
        }
        Iterator iter = tempMap.entrySet().iterator();
        List<Integer> rank = new ArrayList<Integer>();
        boolean flag1 = false, flag2 = false;
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            rank.add((Integer)entry.getKey());
        }
        boolean flag= false;
        rank.remove(rank.indexOf(1));
        for(int i = 0; i < rank.size()-1; i++){
            if(rank.get(i)+1 == rank.get(i+1)){
                flag = true;
            }
        }
        if(flag){
            return true;
        }
        return false;
    }

    private boolean fullHouse(List<Card> cardList) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        for (Card card : cardList) {
            if (tempMap.containsKey(card.getRank())) {
                Integer count = tempMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getRank(), count);
            } else {
                tempMap.put(card.getRank(), new Integer(1));
            }
        }
        boolean flag1=false,flag2 = false;
        for (Integer key : tempMap.keySet()) {
           if(tempMap.get(key) == 3){
               flag1 = true;
           }
           if(tempMap.get(key) == 2){
                flag2 = true;
           }
        }
        if(flag1 && flag2){
            return true;
        }
        return false;
    }



}
