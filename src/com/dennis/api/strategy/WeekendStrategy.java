package com.dennis.api.strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
    Monday("1", i -> "Monday"),
    Tuesday("2", i -> "Tuesday"),
    Wednesday("3", i -> "Wednesday"),
    Thursday("4", i -> "Thursday"),
    Friday("5", i -> "Friday"),
    Saturday("6", i -> "Saturday"),
    Sunday("7", i -> "Sunday"),
    Wrong("?", i -> "Wrong")
    ;

    private final String input;
    private final Function<String, String> function;

    WeekendStrategy(String input, Function<String, String> function) {
        this.input = input;
        this.function = function;
    }

    public static String excute(Scanner sc) {
        System.out.println("1~7 입력: ");
        String day = sc.next();
        return Stream.of(values())
                .filter(i -> i.input.equals(day))
                .findAny().orElseGet(() -> Wrong)
                .function.apply(day);
    }
}
