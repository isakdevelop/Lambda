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

public enum MainEnum {
    Exit("e", scanner -> false),
    User("u", scanner -> {
        try {
            UserView.main(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Article("a", scanner -> {
        try {
            ArticleView.main(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Board("b", scanner -> {
        BoardView.main(scanner);
        return true;
    }),
    Crawler("c", scanner -> {
        try {
            CrawlerView.main(scanner);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Account("m", scanner -> {
        AccountView.main(scanner);
        return true;
    });

    private final String command;
    private final Predicate<Scanner> action;

    MainEnum(String command, Predicate<Scanner> action) {
        this.command = command;
        this.action = action;
    }

    public static MainEnum getByCommand(String command) {
        return Arrays.stream(values())
                .filter(o -> o.command.equals(command))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid command."));
    }

    public boolean performAction(Scanner scanner) {
        return action.test(scanner);
    }
}
