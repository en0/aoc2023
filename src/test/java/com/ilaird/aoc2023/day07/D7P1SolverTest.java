package com.ilaird.aoc2023.day07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ilaird.aoc2023.aoc.PartSolverTestBase;

/*
class D7P1SolverTest extends PartSolverTestBase<Hand> {

    @BeforeEach
    void setUp() {
        unit = new D7P1Solver();
        parser = new D7Parser();
        answer = 6440;
        sample = new String[] {
            "32T3K 765",
            "T55J5 684",
            "KK677 28",
            "KTJJT 220",
            "QQQJA 483"
        };

        initMocks();
    }

    @Test
    void canSortEnumBecauseIDonKnow() {
        Card[] cards = { Card.C4, Card.C5, Card.C3, Card.C2, Card.CA, Card.CQ };
        Card[] ordered = { Card.C2, Card.C3, Card.C4, Card.C5, Card.CQ, Card.CA };
        Arrays.sort(cards);
        for (int i = 0; i < ordered.length; i++)
            assertEquals(ordered[i], cards[i]);
    }

    @Test
    void testCardTypeIdentification() {
        assertEquals(
            HandType.FiveOfKind,
            Hand.newP1(new Card[] {Card.CA, Card.CA, Card.CA, Card.CA, Card.CA}, 0).handType
        );
        assertEquals(
            HandType.FourOfKind,
            Hand.newP1(new Card[] {Card.CA, Card.CA, Card.C8, Card.CA, Card.CA}, 0).handType
        );
        assertEquals(
            HandType.FullHouse,
            Hand.newP1(new Card[] {Card.C2, Card.C3, Card.C3, Card.C3, Card.C2}, 0).handType
        );
        assertEquals(
            HandType.ThreeOfKind,
            Hand.newP1(new Card[] {Card.CT, Card.CT, Card.CT, Card.C9, Card.C8}, 0).handType
        );
        assertEquals(
            HandType.TwoPair,
            Hand.newP1(new Card[] {Card.C2, Card.C3, Card.C4, Card.C3, Card.C2}, 0).handType
        );
        assertEquals(
            HandType.OnePair,
            Hand.newP1(new Card[] {Card.CA, Card.C2, Card.C3, Card.CA, Card.C4}, 0).handType
        );
        assertEquals(
            HandType.HighCard,
            Hand.newP1(new Card[] {Card.C2, Card.C3, Card.C4, Card.C5, Card.C6}, 0).handType
        );
    }

    @Test
    void canSortHands() {
        var onePair = Hand.newP1(new Card[] {Card.C3, Card.C2, Card.CT, Card.C3, Card.CK}, 0);
        var threeOfKind1 = Hand.newP1(new Card[] {Card.CT, Card.C5, Card.C5, Card.CJ, Card.C5}, 0);
        var twoPair1 = Hand.newP1(new Card[] {Card.CK, Card.CK, Card.C6, Card.C7, Card.C7}, 0);
        var twoPair2 = Hand.newP1(new Card[] {Card.CK, Card.CT, Card.CJ, Card.CJ, Card.CT}, 0);
        var threeOfKind2 = Hand.newP1(new Card[] {Card.CQ, Card.CQ, Card.CQ, Card.CJ, Card.CA}, 0);

        var hands = new Hand[] {
            onePair,
            threeOfKind1,
            twoPair1,
            twoPair2,
            threeOfKind2
        };

        Arrays.sort(hands);
        assertEquals(onePair, hands[0]);
        assertEquals(twoPair2, hands[1]);
        assertEquals(twoPair1, hands[2]);
        assertEquals(threeOfKind1, hands[3]);
        assertEquals(threeOfKind2, hands[4]);
    }

    @Test
    void testParser() {
        var iter = parser.iterator();
        var hand1 = iter.next();
        assertEquals(765, hand1.bid);
        assertEquals(HandType.OnePair, hand1.handType);
        assertEquals(Card.C3, hand1.hand[0]);
    }
}
*/
