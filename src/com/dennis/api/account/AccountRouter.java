package com.dennis.api.account;

import com.dennis.api.menu.MenuController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    EXIT("0", sc -> {
        return false;
    }),
    MKDIR("1", sc -> {
        return true;
    }),
    CREATE("2", sc -> {
        return true;
    }),
    Login("3", sc -> {
        return true;
    }),
    DEPOSIT("4", sc -> {
        return true;
    }),
    WITHDRAW("5", sc -> {
        return true;
    }),
    BALANCE("6", sc -> {
        return true;
    }),
    REMOVE("7", sc -> {
        return true;
    }),
    ALLACCOUNT("8", sc -> {
        return true;
    }),
    WRONG("?", sc -> {
        return true;
    })
    ;
    private final String command;
    private final Predicate<Scanner> predicate;

    AccountRouter(String command, Predicate<Scanner> predicate) {
        this.command = command;
        this.predicate = predicate;
    }

    public static boolean accountRouter(Scanner sc) throws SQLException {
        List<String> ls = MenuController.getInstance().getMenuList("account");
        ls.forEach(System.out::println);
        String input = sc.next();
        return Stream.of(values())
                .filter(i -> i.command.equals(input))
                .findAny().orElse(WRONG)
                .predicate.test(sc);
    }
}
