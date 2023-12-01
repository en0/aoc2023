package com.ilaird.aoc2023;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ilaird.aoc2023.lib.SolverError;
import com.ilaird.aoc2023.lib.SolverParameterError;
import com.ilaird.aoc2023.lib.SolverRunner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Autowired
    ApplicationContext context;

    @Autowired
    SolverRunner runner;

	public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        if (args.length < 2) {
            logger.warn("Failed to run! Missing arguments.");
            logger.info("Usage: aoc2023 <day> <part>");
            System.exit(1);
        }

        Integer day = 0;
        Integer part = 0;

        try {
            day = Integer.parseInt(args[0]);
        } catch (NumberFormatException ex) {
            logger.error("Unable to parse <day>. Integer Expected");
            System.exit(2);
        }

        try {
            part = Integer.parseInt(args[1]);
        } catch (NumberFormatException ex) {
            logger.error("Unable to parse <part>. Integer Expected");
            System.exit(2);
        }

        try {
            runner.solve(day, part);
        } catch (SolverParameterError ex) {
            logger.error("Parameter Error: " + ex.getMessage());
        } catch (SolverError ex) {
            logger.error("Failed to run solver!", ex);
        }
    }

}
