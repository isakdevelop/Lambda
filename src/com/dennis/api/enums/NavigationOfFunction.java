package com.dennis.api.enums;

import com.dennis.api.account.AccountView;
import com.dennis.api.article.Article;
import com.dennis.api.article.ArticleView;
import com.dennis.api.board.BoardView;
import com.dennis.api.crawler.CrawlerView;
import com.dennis.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {
    Exit("exit", i -> String.valueOf(Messenger.FAIL)),
    User("user", i ->
    {
        try {
            UserView.main(i);
            return String.valueOf(Messenger.SUCCESS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    Article("article", i ->
    {
        try {
            ArticleView.main(i);
            return String.valueOf(Messenger.SUCCESS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    Board("board", i ->
    {
        try {
            BoardView.main(i);
            return String.valueOf(Messenger.SUCCESS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    Crawler("crawler", i -> {
        try {
            CrawlerView.main(i);
            return String.valueOf(Messenger.SUCCESS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }),
    Account("account", i -> {
        try {
            AccountView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(Messenger.SUCCESS);
    }),
    InputError("input_error", i -> String.valueOf(Messenger.FAIL))
    ;
    private final String command;
    private final Function<Scanner, String> function;

    NavigationOfFunction(String command, Function<Scanner, String> function) {
        this.command = command;
        this.function = function;
    }

    public static String select(Scanner sc) {
        System.out.println("exit - Exit \n" +
                "user - User\n" +
                "article - Article\n" +
                "board - Board\n" +
                "crawler - Crawler\n" +
                "account - Account");
        System.out.print("input command : ");
        String input = sc.next();
        return Stream.of(values()).filter(i -> i.command.equals(input))
                .findAny().orElse(InputError).function.apply(sc);
    }
}
