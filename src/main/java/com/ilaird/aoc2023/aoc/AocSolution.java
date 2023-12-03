package com.ilaird.aoc2023.aoc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AocSolution {
    int day();
    int part() default 1;
}
