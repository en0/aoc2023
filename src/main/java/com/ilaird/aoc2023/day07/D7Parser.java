package com.ilaird.aoc2023.day07;

import org.springframework.stereotype.Component;

import com.ilaird.aoc2023.aoc.LnXfmPuzzleInput;
import com.ilaird.aoc2023.aoc.TransformError;

@Component
class D7Parser extends LnXfmPuzzleInput<Hand> {
    @Override
    public Hand transform(String input) throws TransformError {
        var parts = input.split(" ");
        var bid = Integer.parseInt(parts[1]);
        var cards = new Card[5];
        for (int i = 0; i < parts[0].length(); i++)
            cards[i] = Card.valueOf("C" + parts[0].charAt(i));
        var hand = Hand.newP1(cards, bid);
        return hand;
    }
}
