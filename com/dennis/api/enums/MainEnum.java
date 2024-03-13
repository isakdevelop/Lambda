package com.dennis.api.enums;

import com.dennis.api.account.AccountView;
import com.dennis.api.article.ArticleView;
import com.dennis.api.board.BoardView;
import com.dennis.api.crawler.CrawlerView;
import com.dennis.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum MainEnum {
    Exit("e", sc -> false),
    User("u", sc -> {
        try {
            UserView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Article("a", sc -> {
        try {
            ArticleView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Board("b", sc -> {
        BoardView.main(sc);
        return true;
    }),
    Crawler("c", sc -> {
        try {
            CrawlerView.main(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Account("m", sc -> {
        AccountView.main(sc);
        return true;
    }),
    INPUTERROR("input_error", i -> {
        System.out.println("Invalid input value");
        return true;
    });

    private final String command;
    private final Predicate<Scanner> action;

    MainEnum(String command, Predicate<Scanner> action) {
        this.command = command;
        this.action = action;
    }
    public static boolean performAction(Scanner sc) {
        System.out.println("e - Exit \n" +
                "u - User\n" +
                "a - Article\n" +
                "b - Board\n" +
                "c - Crawler\n" +
                "m - Account");
        System.out.print("input command : ");
        String command = sc.next();
        return Stream.of(values()).filter(i -> i.command.equals(command))
                .findAny().orElse(INPUTERROR).action.test(sc);
    }
}
