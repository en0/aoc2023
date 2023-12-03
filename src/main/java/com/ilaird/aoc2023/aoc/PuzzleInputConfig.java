package com.ilaird.aoc2023.aoc;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
class PuzzleInputConfig {

    @Value("${aoc2023.day}")
    private int day;

    @Value("${aoc2023.part}")
    private int part;

    @Bean
    public String[] puzzleInput() {
        var name = String.format("day%02d.txt", this.day);
        var resource = new ClassPathResource(name);
        try (InputStream stream = resource.getInputStream()){
            var inputString = new String(stream.readAllBytes());
            return inputString.split("\n");
        } catch (IOException ex) {
            return null;
        }
    }
}
