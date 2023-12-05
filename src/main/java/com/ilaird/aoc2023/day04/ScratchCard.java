package com.ilaird.aoc2023.day04;

import java.util.HashSet;
import java.util.Set;

class ScratchCard {

    int cardNumber;
    Set<Integer> winningNumbers;
    Set<Integer> givenNumbers;

    int getValue() {
        Set<Integer> ret = new HashSet<>(winningNumbers);
        ret.retainAll(givenNumbers);
        return ret.size();
    }
}
