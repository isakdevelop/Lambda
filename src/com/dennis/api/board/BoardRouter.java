package com.dennis.api.board;

import com.dennis.api.menu.MenuController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum BoardRouter {
    Exit("0", sc -> false),
    MKDIR("1", sc -> {
        return true;
    }),
    SELECTBOARD("2", sc -> {
        return true;
    }),
    SELECTTYPE("3", sc -> {
        return true;
    }),
    WRONG("?", sc -> {
        return true;
    })
    ;
    private final String command;
    private final Predicate<Scanner> predicate;

    BoardRouter(String command, Predicate<Scanner> predicate) {
        this.command = command;
        this.predicate = predicate;
    }

    public static boolean boardRouter(Scanner sc) throws SQLException {
        List<String> ls = MenuController.getInstance().getMenuList("board");
        ls.forEach(System.out::println);

        String input = sc.next();
        return Stream.of(values())
                .filter(i -> i.command.equals(input))
                .findAny().orElse(WRONG)
                .predicate.test(sc);
    }
}
