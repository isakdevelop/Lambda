package com.dennis.api.enums;

import com.dennis.api.account.AccountView;
import com.dennis.api.article.ArticleView;
import com.dennis.api.board.BoardView;
import com.dennis.api.crawler.CrawlerView;
import com.dennis.api.menu.MenuController;
import com.dennis.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {
    Exit("0", sc -> false),
    User("1", sc -> {
        try {
            UserView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Article("2", sc -> {
        try {
            ArticleView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Board("3", sc -> {
        try {
            BoardView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Crawler("4", sc -> {
        try {
            CrawlerView.main(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Account("5", sc -> {
        try {
            AccountView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    InputError("input_error", i -> {
        System.out.println("Invalid input value");
        return true;
    });

    private final String command;
    private final Predicate<Scanner> predicate;

    Navigation(String command, Predicate<Scanner> predicate) {
        this.command = command;
        this.predicate = predicate;
    }
    public static boolean navigate(Scanner sc) throws SQLException {
        List<String> ls = MenuController.getInstance().getMenuList("navigate");
        ls.forEach(System.out::println);

        String input = sc.next();
        return Stream.of(values())
                .filter(i -> i.command.equals(input))
                .findAny().orElse(InputError)
                .predicate.test(sc);
    }
}
