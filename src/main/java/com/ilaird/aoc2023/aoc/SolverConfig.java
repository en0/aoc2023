package com.ilaird.aoc2023.aoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
class SolverConfig {

    @Autowired
    List<Solver> solvers;

    @Value("${aoc2023.day}")
    private int day;

    @Value("${aoc2023.part}")
    private int part;

    @Bean
    @Primary
    public Solver getSolver() {
        for (Solver solver : solvers) {
            AocSolution solutionAnno = solver.getClass().getAnnotation(AocSolution.class);
            if (solutionAnno.day() == day && solutionAnno.part() == part)
                return solver;
        }
        return null;
    }
}
