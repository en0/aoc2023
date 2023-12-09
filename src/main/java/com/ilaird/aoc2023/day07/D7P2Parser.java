package com.ilaird.aoc2023.day07;

import org.springframework.stereotype.Component;

@Component("d7p2")
class D7P2Parser extends D7P1Parser {
    @Override
    Card toCardEnum(char c) {
        return Card.valueOf("C" + (c == 'J' ? 'W' : c));
    }
}
