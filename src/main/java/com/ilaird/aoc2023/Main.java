package com.ilaird.aoc2023;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import com.ilaird.aoc2023.aoc.Solver;

@Profile("!test")
@SpringBootApplication
public class Main implements CommandLineRunner {

    static class StartupException extends Exception {
        StartupException(String msg) { super(msg); }
    }

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Autowired
    Solver solver;

    @Value("${aoc2023.day}")
    private int day;

    @Value("${aoc2023.part}")
    private int part;

	public static void main(String[] args) {
        try {
            setSystemProperties(args);
        } catch (StartupException ex) {
            logger.warn(ex.getMessage());
            System.exit(1);
        }
        SpringApplication.run(Main.class, args);
	}

    private static void setSystemProperties(String[] args) throws StartupException {
        ApplicationArguments arguments = new DefaultApplicationArguments(args);
        int day = getIntValue(arguments, "day", 1, 25);
        int part = getIntValue(arguments, "part", 1, 2);
        System.setProperty("aoc2023.day", Integer.toString(day));
        System.setProperty("aoc2023.part", Integer.toString(part));
    }

    private static int getIntValue(ApplicationArguments args, String name, int minValue, int maxValue) throws StartupException {

        if (!args.containsOption(name))
            return minValue;

        try {

            var opts = args.getOptionValues(name);
            var value = Integer.parseInt(opts.get(0));
            if (value >= minValue && value <= maxValue)
                return value;
            throw new StartupException("The value for argument \"" + name + "\" is invalid. Expecting a number between " + minValue + " and " + maxValue + ".");
        } catch (NumberFormatException e) {
            throw new StartupException("Unable to decode argument \"" + name + "\". Expecting a number between " + minValue + " and " + maxValue + ".");
        }
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Running solver for day {} part {}.", day, part);
        var result = solver.solve();
        System.out.println("ANS: " + result);
    }
}
