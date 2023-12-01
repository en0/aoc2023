package com.ilaird.aoc2023.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class SolverRunner {

    @Autowired
    ApplicationContext context;

    public void solve(int day, int part) throws SolverError {
        validateParameters(day, part);
        var solver = getSolver(day);
        var input = getInput(day);
        var result = runSolver(solver, part, input);
        System.out.println("ANS: " + result);
    }

    private int runSolver(DaySolver solver, int part, Resource input) throws SolverError {
        try (InputStream stream = input.getInputStream()) {
            var streamReader = new InputStreamReader(stream);
            var reader = new BufferedReader(streamReader);
            if (part == 1)
                return solver.solvePart1(reader);
            else
                return solver.solvePart2(reader);
        } catch (IOException ex) {
            throw new SolverParameterError("Unexpected I/O error: " + ex.getMessage());
        }
    }

    private void validateParameters(int day, int part) throws SolverError {
        if (day < 1 || day > 31)
            throw new SolverParameterError("Invalid day. Must be between 1 and 31");
        else if (part != 2 && part != 1)
            throw new SolverParameterError("Invalid part. Must be 1 or 2");
    }

    private DaySolver getSolver(int day) throws SolverError {
        var d = String.format("%02d", day);
        var beanName = "day" + d + "Solver";
        if (!context.containsBean(beanName))
            throw new SolverParameterError("Unable to find solver for day " + day + ".");
        return (DaySolver) context.getBean(beanName);
    }

    private Resource getInput(int day) throws SolverError {
        var d = String.format("%02d", day);
        var resourceName = "day" + d + ".txt";
        var resource = new ClassPathResource(resourceName);
        if (!resource.exists())
            throw new SolverParameterError("Unable to find input for day " + day + ".");
        return resource;
    }
}
