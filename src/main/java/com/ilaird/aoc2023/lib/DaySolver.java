package com.ilaird.aoc2023.lib;

import java.io.BufferedReader;
import java.io.IOException;

public interface DaySolver {
    int solvePart1(BufferedReader reader) throws SolverError, IOException;
    int solvePart2(BufferedReader reader) throws SolverError, IOException;
}
