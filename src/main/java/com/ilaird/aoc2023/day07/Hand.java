package com.ilaird.aoc2023.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


class Hand implements Comparable<Hand>{

    public final int bid;
    public final Card[] hand;
    protected HandType handType;

    public static Hand newP1(Card[] hand, int bid) {
        var ret = new Hand(hand, bid);
        ret.eval();
        return ret;
    }

    private Hand(Card[] hand, int bid) {
        this.hand = hand;
        this.bid = bid;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (Card c : hand)
            sb.append(c);
        sb.append(" (" + handType + ")");
        return sb.toString();
    }

    @Override
    public int compareTo(Hand o) {
        var ret = 0;
        if (this.handType.ordinal() > o.handType.ordinal())
            ret = 1;
        else if (this.handType.ordinal() < o.handType.ordinal())
            ret = -1;
        else {
            for (var i = 0; i < hand.length; i++) {
                if (hand[i].ordinal() > o.hand[i].ordinal()) {
                    ret = 1;
                    break;
                } else if (hand[i].ordinal() < o.hand[i].ordinal()) {
                    ret = -1;
                    break;
                }
            }
        }
        return ret;
    }

    private final void eval() {

        var c = 1;
        var counts = new ArrayList<Integer>();
        var hand1 = Arrays.copyOf(this.hand, this.hand.length);

        Arrays.sort(hand1);

        var w = hand1[0] == Card.CW ? 1 : 0;

        for (int i = 1; i < hand1.length; i++) {
            if (hand1[i] == Card.CW) {
                w++;
                c = 1;
            } else if (hand1[i] == hand1[i-1]) {
                c++;
            } else {
                counts.add(c);
                c = 1;
            }
        }

        counts.add(c);
        counts.add(0);
        Collections.sort(counts, Collections.reverseOrder());

        var h1 = counts.get(0) + w;
        var h2 = counts.get(1);

        if (h1 == 6)
            // hack to work around a bug for part2
            handType = HandType.FiveOfKind;
        else if (h1 == 5)
            handType = HandType.FiveOfKind;
        else if (h1 == 4)
            handType = HandType.FourOfKind;
        else if (h1 == 3 && h2 == 2)
            handType = HandType.FullHouse;
        else if (h1 == 3)
            handType = HandType.ThreeOfKind;
        else if (h1 == 2 && h2 == 2)
            handType = HandType.TwoPair;
        else if (h1 == 2)
            handType = HandType.OnePair;
        else
            handType = HandType.HighCard;
    }
}
