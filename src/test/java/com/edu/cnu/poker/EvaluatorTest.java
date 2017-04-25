package com.edu.cnu.poker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by cse on 2017-04-17.
 */
public class EvaluatorTest {

    @Test
    public void SUIT가_5개가동일하면_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FLUSH"));
    }

    @Test
    public void A가없는_RANK가_연속으로5개이면_스트레이트이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(4, Suit.DIAMONDS),
                new Card(5, Suit.HEARTS),
                new Card(6, Suit.SPADES),
                new Card(7, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("STRAIGHT"));

    }

    @Test
    public void RANK가_10에서A이면_마운틴이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(10, Suit.DIAMONDS),
                new Card(11, Suit.HEARTS),
                new Card(12, Suit.SPADES),
                new Card(13, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("MOUNTAIN"));
    }

    @Test
    public void RANK가_A에서5이면_백스트레이트이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.DIAMONDS),
                new Card(3, Suit.HEARTS),
                new Card(4, Suit.SPADES),
                new Card(5, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("BACKSTRAIGHT"));
    }

    @Test
    public void RANK가_4개가같으면_포카드이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(3, Suit.DIAMONDS),
                new Card(3, Suit.HEARTS),
                new Card(3, Suit.SPADES),
                new Card(5, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FOURCARD"));
    }

    @Test
    public void RANK가_3개가같고나머지2개가서로같으면_풀하우스이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(3, Suit.DIAMONDS),
                new Card(3, Suit.HEARTS),
                new Card(5, Suit.SPADES),
                new Card(5, Suit.CLUBS)

        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FULLHOUSE"));
    }

    @Test
    public void RANK가_3개가같으면_트리플이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(3, Suit.DIAMONDS),
                new Card(3, Suit.HEARTS),
                new Card(4, Suit.SPADES),
                new Card(5, Suit.CLUBS)

        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("TRIPLE"));
    }

    @Test
    public void RANK가_2개가같으면_원페어이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(4, Suit.DIAMONDS),
                new Card(3, Suit.HEARTS),
                new Card(4, Suit.SPADES),
                new Card(5, Suit.CLUBS)

        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("ONEPAIR"));

    }

    @Test
    public void 원페어가두개면_투페어이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(4, Suit.DIAMONDS),
                new Card(3, Suit.HEARTS),
                new Card(4, Suit.SPADES),
                new Card(5, Suit.CLUBS)

        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("TWOPAIR"));

    }

    @Test
    public void 스트레이트이고플러시이면_스트레이트플러시이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.CLUBS),
                new Card(6, Suit.CLUBS),
                new Card(7, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("STRAIGHTFLUSH"));

    }

    @Test
    public void 백스트레이트이고플러시이면_백스트레이트플러시이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.CLUBS),
                new Card(3, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("STRAIGHTFLUSH"));
    }

    @Test
    public void 마운틴에플러시이면_로얄스트레이트플러시이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(11, Suit.CLUBS),
                new Card(12, Suit.CLUBS),
                new Card(13, Suit.CLUBS),
                new Card(10, Suit.CLUBS),
                new Card(1, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("LOYALSTRAIGHTFLUSH"));
    }



}